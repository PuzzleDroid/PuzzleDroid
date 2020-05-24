package com.awaredevelopers.puzzledroid

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.GridView
import android.widget.ImageView
import com.awaredevelopers.puzzledroid.ui.nPuzzle.NPuzzleAdapter
import com.awaredevelopers.puzzledroid.utils.CreateImageSliced
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_npuzzle.*


class NPuzzleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_npuzzle)
//        val imageView: ImageView = findViewById<View>(R.id.myImageView) as ImageView
//        Glide.with(this).load(nPuzzleList[23].drawable)
//            .into(imageView)



        var bmp = BitmapFactory.decodeStream(assets.open("cities_img/ny_west_44th_street.jpg"))
        var nPuzzleList = CreateImageSliced.getListImageSliced(bmp)


        // Get an instance of base adapter
        val adapter = NPuzzleAdapter(nPuzzleList)

        // Set the grid view adapter
        nPuzzleGridView.adapter = adapter

        // Configure the grid view
        nPuzzleGridView.numColumns = nPuzzleList[0].numCols
//        nPuzzleGridView.horizontalSpacing = 15
//        nPuzzleGridView.verticalSpacing = 15
     //   nPuzzleGridView.stretchMode = GridView.STRETCH_COLUMN_WIDTH
//        nPuzzleGridView.stretchMode = GridView.autofill
    }
}
