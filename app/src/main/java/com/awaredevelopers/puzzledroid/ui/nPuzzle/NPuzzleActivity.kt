package com.awaredevelopers.puzzledroid.ui.nPuzzle

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.SystemClock
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.model.*
import kotlinx.android.synthetic.main.activity_npuzzle.*

class NPuzzleActivity : AppCompatActivity() {
    private val TAG = "NPuzzleActivity"
    lateinit var nPuzzle: NPuzzle
    lateinit var chronometer: Chronometer
    private var chronoLastStopTime = 0L
    val IMAGE_PICK_CODE = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "MODE SELECTED: ${intent.extras?.getInt("GameModeKey").toString()}")

        super.onCreate(savedInstanceState)
        hideSystemUI()
        setContentView(R.layout.activity_npuzzle)
        openGallery()

        when(intent.extras?.getInt("GameModeKey")) {
            1 -> nPuzzle = NPuzzlePreloaded(applicationContext)
            2 -> nPuzzle = NPuzzleGallery(applicationContext)
            3 -> nPuzzle = NPuzzleCam(applicationContext)
            4 -> nPuzzle = NPuzzleFirebase(applicationContext)
            else ->  Log.d(TAG, "MODE SELECTED OUT OF RANGE!")
        }
        val nPuzzleList = nPuzzle.nPuzzlePortions

        // Get an instance of base adapter
        val adapter = NPuzzleAdapter(nPuzzle)

        // Set the grid view adapter
        nPuzzleGridView.adapter = adapter

        // Configure the grid view
        nPuzzleGridView.numColumns = nPuzzleList[0].numCols

        // Starts chronometer
        chronometer = findViewById<Chronometer>(R.id.chronometer)
        chronometer.start()
    }

    override fun onPause() {
        super.onPause()
        chronometer.stop()
        chronoLastStopTime = SystemClock.elapsedRealtime()
    }

    override fun onResume() {
        super.onResume()
        if (chronoLastStopTime == 0L) {
            chronometer.base = SystemClock.elapsedRealtime()
        } else {
            chronometer.base += SystemClock.elapsedRealtime() - chronoLastStopTime
        }
        chronometer.start()
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
    fun buttonBackMenu(view: View) {
        //TODO que no muestre el splash de carga al volver al menu inicial
        findNavController(view).navigate(R.id.nav_home)
//        val intent = Intent(parent.applicationContext, HomeFragment::class.java)
//        startActivity(intent)
    }

    fun buttonNextLevel(view: View) {
        finish()
        startActivity(intent);
    }
    fun openGallery() {
        val intentOpenGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intentOpenGallery.type = "image/*"
        startActivityForResult(intentOpenGallery, IMAGE_PICK_CODE)
    }
    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {


        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {

            NPuzzleGallery.bmp = BitmapFactory.decodeFile(data?.data.toString())
        }
    }
}
