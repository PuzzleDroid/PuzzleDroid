package com.awaredevelopers.puzzledroid.ui.intentActivity

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.awaredevelopers.puzzledroid.ui.nPuzzle.NPuzzleActivity
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStream


class IntentActivity : AppCompatActivity() {
    var bmp: Bitmap? = null
    private val TAG = "NPuzzleIntent"
    val IMAGE_PICK_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
//        Log.d(TAG, "MODE SELECTED: ${intent.extras?.getInt("GameModeKey").toString()}")

        super.onCreate(savedInstanceState)
        hideSystemUI()
//        setContentView(R.layout.activity_npuzzle)
        openGallery()



//        when(intent.extras?.getInt("GameModeKey")) {
//            1 -> nPuzzle = NPuzzlePreloaded(applicationContext)
//            2 -> nPuzzle = NPuzzleGallery(applicationContext)
//            3 -> nPuzzle = NPuzzleCam(applicationContext)
//            4 -> nPuzzle = NPuzzleFirebase(applicationContext)
//            else ->  Log.d(TAG, "MODE SELECTED OUT OF RANGE!")
//        }

    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                   View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
    fun openGallery() {
        val intentOpenGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intentOpenGallery.type = "image/*"
        startActivityForResult(intentOpenGallery, IMAGE_PICK_CODE)
    }
    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            val selectedImage: Uri? = data?.data?.path?.toUri()
            var inputStream: InputStream? = null

            if (ContentResolver.SCHEME_CONTENT == selectedImage!!.scheme) {
                try {
                    inputStream = this.contentResolver.openInputStream(selectedImage!!)
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                }
            } else {
                if (ContentResolver.SCHEME_FILE == selectedImage!!.scheme) {
                    try {
                        inputStream = FileInputStream(selectedImage!!.path)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }
                }
            }
            bmp = BitmapFactory.decodeStream(inputStream)
        }

    }

    private fun startNPuzzleActivityGameMode(gameModeValue: Int, bmp: Bitmap) {
        val intent = Intent(this, NPuzzleActivity::class.java)
        val b = Bundle()
        b.putInt("GameModeKey", gameModeValue)
        intent.putExtras(b)
        intent.putExtra("bmp", bmp)
        startActivity(intent)
    }
}
