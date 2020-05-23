package com.awaredevelopers.puzzledroid

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.awaredevelopers.puzzledroid.ui.home.HomeFragment
import android.widget.GridView
import com.awaredevelopers.puzzledroid.ui.NPuzzle.ColorBaseAdapter
import kotlinx.android.synthetic.main.activity_npuzzle.*


class NPuzzleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_npuzzle)


        // Get an instance of base adapter
        val adapter = ColorBaseAdapter()

        // Set the grid view adapter
        grid_view.adapter = adapter

        // Configure the grid view
        grid_view.numColumns = 2
        grid_view.horizontalSpacing = 15
        grid_view.verticalSpacing = 15
        grid_view.stretchMode = GridView.STRETCH_COLUMN_WIDTH

    }
}
