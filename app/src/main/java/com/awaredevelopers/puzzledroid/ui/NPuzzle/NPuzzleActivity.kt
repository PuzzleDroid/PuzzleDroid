package com.awaredevelopers.puzzledroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.GridView
import com.awaredevelopers.puzzledroid.ui.NPuzzle.Adapter
import kotlinx.android.synthetic.main.activity_npuzzle.*


class NPuzzleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_npuzzle)


        // Get an instance of base adapter
        val adapter = Adapter()

        // Set the grid view adapter
        grid_view.adapter = adapter

        // Configure the grid view
        grid_view.numColumns = 4
        grid_view.horizontalSpacing = 15
        grid_view.verticalSpacing = 15
        grid_view.stretchMode = GridView.STRETCH_COLUMN_WIDTH
    }
}
