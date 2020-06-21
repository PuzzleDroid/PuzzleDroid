package com.awaredevelopers.puzzledroid.ui.nPuzzle

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.awaredevelopers.puzzledroid.MainActivity
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.utils.CreateImageSliced
import kotlinx.android.synthetic.main.activity_npuzzle.*

class NPuzzleActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_npuzzle)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR or View.SYSTEM_UI_FLAG_FULLSCREEN

        //TODO get random img from assets
        val bmp = BitmapFactory.decodeStream(assets.open("cities_img/ny_west_44th_street.jpg"))
        val intent = Intent(this, MainActivity::class.java)
        val nPuzzleList = CreateImageSliced.getListImageSliced(bmp)

        // Get an instance of base adapter
        val adapter = NPuzzleAdapter(nPuzzleList)

        // Set the grid view adapter
        nPuzzleGridView.adapter = adapter

        // Configure the grid view
        nPuzzleGridView.numColumns = nPuzzleList[0].numCols
    }
}
