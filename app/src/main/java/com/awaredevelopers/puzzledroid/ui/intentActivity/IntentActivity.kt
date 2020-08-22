package com.awaredevelopers.puzzledroid.ui.intentActivity

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.awaredevelopers.puzzledroid.ui.nPuzzle.NPuzzleActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.net.URL
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class IntentActivity : AppCompatActivity() {


    private val TAG = "NPuzzleIntent"
    private lateinit var gameMode: String
    val IMAGE_PICK_CODE = 1000
    val REQUEST_CAMERA= 1002

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameMode = intent.extras?.getInt("GameModeKey").toString()

        if(gameMode == "2" && askForPermissionsGallery()){
                Log.d(TAG, "PERMISSIONS: ACCESS GRANTED TO GALLERY")
                openGallery()
        } else if (gameMode == "3" && askForPermissionsCam()) {
            Log.d(TAG, "PERMISSIONS: ACCESS GRANTED TO CAMERA")
            openCamera()
        } else if (gameMode == "4"){
            getFromFirebase()
        } else {
            Log.d(TAG, "PERMISSIONS: ACCESS DENIED MODE ${intent.extras?.getInt("GameModeKey").toString()}")
            showPermissionDeniedDialog()
        }
    }

    private fun getFromFirebase() {
        var storage = FirebaseStorage.getInstance("gs://puzzledroid-fadc9.appspot.com")
        var listRef = storage.getReference()
        var result = ArrayList<Task<Uri>>()

        suspend fun getImages(listRef: StorageReference): Uri {
            return suspendCoroutine { continuation ->
                val list = listRef.listAll()

                list.addOnSuccessListener { listResult ->
                    listResult.items.forEach { item ->
                        result.add(item.downloadUrl)
                    }

                    result[0].addOnSuccessListener { uri ->
                        continuation.resume(uri)
                    }
                }

                list.addOnFailureListener {
                    it
                }
            }
        }

        GlobalScope.launch{
            var route: Uri = Uri.EMPTY
            launch{
                route = getImages(listRef)
            }.join()

            run {
                val url = URL(route.toString())
                val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                startNPuzzleActivityGameMode(4, route, bmp)
            }
        }
    }

    private fun openGallery() {
        val intentOpenGallery = Intent(Intent.ACTION_GET_CONTENT)
        intentOpenGallery.type = "image/*"
        startActivityForResult(intentOpenGallery, IMAGE_PICK_CODE)
    }

    private var image_uri: Uri? = null
    private fun openCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        //camera intent
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, REQUEST_CAMERA)
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var imageUri: Uri? = null
            if (requestCode == IMAGE_PICK_CODE){
                imageUri = data?.data
            } else if (requestCode == REQUEST_CAMERA) {
                imageUri = image_uri
            }
            startNPuzzleActivityGameMode(gameMode.toInt(), imageUri, null)
        } else {
            onBackPressed()
        }
    }

    private fun startNPuzzleActivityGameMode(gameModeValue: Int, imageUri: Uri?, bmp: Bitmap?) {
        val intent = Intent(this, NPuzzleActivity::class.java)
        val b = Bundle()
        b.putInt("GameModeKey", gameModeValue)
        b.putString("imageUri", imageUri.toString())

        if (bmp != null) {
            val stream = ByteArrayOutputStream()
            bmp!!.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val byteArray: ByteArray = stream.toByteArray()
            b.putByteArray("bmp", byteArray)
        }

        intent.putExtras(b)
        startActivityForResult(intent, 1)
    }

    private fun isPermissionsAllowedGallery(): Boolean {
        return ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    }

    private fun askForPermissionsGallery(): Boolean {
        if (!isPermissionsAllowedGallery()) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this as Activity,Manifest.permission.READ_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(this as Activity,arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),IMAGE_PICK_CODE)
            }
            return false
        }
        return true
    }

    private fun isPermissionsAllowedCam(): Boolean {
        return ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    private fun askForPermissionsCam(): Boolean {
        if (!isPermissionsAllowedCam()) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this as Activity,Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(this as Activity,arrayOf(Manifest.permission.CAMERA),REQUEST_CAMERA)
            }
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<String>,grantResults: IntArray) {
        when (requestCode) {
            IMAGE_PICK_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openGallery()
                }
                return
            }
            REQUEST_CAMERA -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera()
                }
                return
            }
        }
    }

    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(this)
            .setTitle("Permission Denied")
            .setMessage("Permission is denied, Please allow permissions from App Settings.")
            .setPositiveButton("App Settings",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    // send to app settings if permission is denied permanently
                    val intent = Intent()
                    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                    val uri = Uri.fromParts("package", packageName, null)
                    intent.data = uri
                    startActivity(intent)
                })
            .setNegativeButton("Cancel", null)
            .show()
    }
}
