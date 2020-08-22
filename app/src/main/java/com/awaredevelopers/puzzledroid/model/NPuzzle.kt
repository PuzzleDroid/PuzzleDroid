package com.awaredevelopers.puzzledroid.model

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.awaredevelopers.puzzledroid.MainActivity
import com.awaredevelopers.puzzledroid.utility.IS_DEBUG
import com.awaredevelopers.puzzledroid.utility.NPuzzlePortion

abstract class NPuzzle : AppCompatActivity{
    protected enum class GameMode {
        PRELOADED_IMG,
        RANDOM_GALLERY_IMG,
        CAM_PICTURE_IMG,
        FIREBASE_IMG;
    }

    var imgName: String
    protected var context: Context
    protected var cols = 0
    protected var rows = 0
    var id = 0
    var level = MainActivity.user.level
    private var gameMode: GameMode
    protected var bitmap: Bitmap
    var nPuzzlePortions: List<NPuzzlePortion>

    protected constructor(
        applicationContext: Context,
        gameMode: GameMode
    ){
        this. id = 1
        this.imgName = ""
        this.context = applicationContext
        setRowsAndCols(level)
        this.gameMode = gameMode
        this.bitmap = BitmapFactory.decodeStream(context.assets.open("preloaded_npuzzle_img/ny_west_44th_street.jpg"))
        this.nPuzzlePortions = createNPuzzlePortions()
    }

    protected constructor(
        applicationContext: Context,
        gameMode: GameMode,
        bitmap: Bitmap
    ){
        this.id = 1
        this.imgName = "PICTURE"
        this.context = applicationContext
        setRowsAndCols(level)
        this.gameMode = gameMode
        this.bitmap = bitmap
        this.nPuzzlePortions = createNPuzzlePortions()
    }

    private fun setRowsAndCols(level: Int) {
        if(IS_DEBUG){
            this.cols = 2
            this.rows = 3
        } else {
            this.cols = (level + 1) * 2
            this.rows = this.cols.div(0.666666).toInt()
        }
    }

    protected abstract fun createNPuzzlePortions(): List<NPuzzlePortion>
}