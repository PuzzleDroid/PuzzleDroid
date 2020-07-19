package com.awaredevelopers.puzzledroid.ui.intentActivity

import android.Manifest
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.awaredevelopers.puzzledroid.ui.nPuzzle.NPuzzleActivity
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class IntentActivity : AppCompatActivity() {
    private lateinit var gameMode: String
    private val TAG = "NPuzzleIntent"
    val IMAGE_PICK_CODE = 1000
    val REQUEST_CAMERA= 1002

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameMode = intent.extras?.getInt("GameModeKey").toString()

        if(gameMode == "2" && askForPermissionsGallery()){
                Log.d(TAG, "PERMISSIONS: ACCESS GRANTED TO GALLERY")
                openGallery()
        } else if (gameMode == "3" && askForPermissionsCam()){
                Log.d(TAG, "PERMISSIONS: ACCESS GRANTED TO CAMERA")
                openCamera()
        } else {
            Log.d(TAG, "PERMISSIONS: ACCESS DENIED MODE ${intent.extras?.getInt("GameModeKey").toString()}")
            showPermissionDeniedDialog()
        }
    }

    private fun openGallery() {
        val intentOpenGallery = Intent(Intent.ACTION_GET_CONTENT)
        intentOpenGallery.type = "image/*"
        startActivityForResult(intentOpenGallery, IMAGE_PICK_CODE)
    }
    private fun openCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    // Error occurred while creating the File
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).also { mediaScanIntent ->
                        val f = File(currentPhotoPath)
                        mediaScanIntent.data = Uri.fromFile(f)
                        sendBroadcast(mediaScanIntent)
                    }
                    startActivityForResult(takePictureIntent, REQUEST_CAMERA)
                }
            }
        }
    }
    lateinit var currentPhotoPath: String

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }
    }
    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && (requestCode == IMAGE_PICK_CODE || requestCode == REQUEST_CAMERA)) {
            val imageUri: Uri? = data?.data
            startNPuzzleActivityGameMode(gameMode.toInt(), imageUri)
        } else {
            onBackPressed()
        }
    }

    private fun startNPuzzleActivityGameMode(gameModeValue: Int, imageUri: Uri?) {
        val intent = Intent(this, NPuzzleActivity::class.java)
        val b = Bundle()
        b.putInt("GameModeKey", gameModeValue)
        b.putString("imageUri", imageUri.toString())
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
