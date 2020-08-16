package com.awaredevelopers.puzzledroid.ui.nPuzzle

import android.net.Uri
import android.os.Bundle
import android.os.SystemClock
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.InvalidationTracker
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.db.AppDatabase
import com.awaredevelopers.puzzledroid.db.entity.UserEntity
import com.awaredevelopers.puzzledroid.model.*
import com.awaredevelopers.puzzledroid.utility.AudioFactory.createAudio
import com.awaredevelopers.puzzledroid.utility.AudioFactory.pauseAudio
import com.awaredevelopers.puzzledroid.utility.AudioFactory.resumeAudio
import com.awaredevelopers.puzzledroid.utility.AudioFactory.stopAudio
import kotlinx.android.synthetic.main.activity_npuzzle.*


@Suppress("DEPRECATION")
class NPuzzleActivity : AppCompatActivity() {
    private val TAG = "NPuzzleActivity"
    lateinit var nPuzzle: NPuzzle
    lateinit var chronometer: Chronometer
    private var chronoLastStopTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "MODE SELECTED: ${intent.extras?.getInt("GameModeKey").toString()}")

        super.onCreate(savedInstanceState)
        hideSystemUI()
        createAudio(this, delegate, window)

        when(intent.extras?.getInt("GameModeKey")) {
            1 -> nPuzzle = NPuzzlePreloaded(applicationContext)
            2 -> nPuzzle = NPuzzleGallery(applicationContext, MediaStore.Images.Media.getBitmap(contentResolver, Uri.parse(intent.extras?.getString("imageUri"))))
            3 -> nPuzzle = NPuzzleCam(applicationContext, MediaStore.Images.Media.getBitmap(contentResolver, Uri.parse(intent.extras?.getString("imageUri"))) )
            4 -> nPuzzle = NPuzzleFirebase(applicationContext)
            else ->  Log.d(TAG, "MODE SELECTED OUT OF RANGE!")
        }

        val nPuzzleList = nPuzzle.nPuzzlePortions

        // Get an instance of base adapter
        val adapter = NPuzzleAdapter(nPuzzle, this)

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
        pauseAudio()
        chronometer.stop()
        chronoLastStopTime = SystemClock.elapsedRealtime()

    }

    override fun onResume() {
        super.onResume()
        resumeAudio()
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
        stopAudio()
        onBackPressed()
    }

    fun buttonNextLevel(view: View) {
        stopAudio()
        finish()
        startActivity(intent);
    }
}
