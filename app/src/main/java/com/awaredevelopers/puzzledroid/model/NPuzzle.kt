package com.awaredevelopers.puzzledroid.model

import android.content.Context
import com.awaredevelopers.puzzledroid.utility.NPuzzlePortion

open abstract class NPuzzle {
    protected enum class GameMode {
        PRELOADED_IMG,
        RANDOM_GALLERY_IMG,
        CAM_PICTURE_IMG,
        FIREBASE_IMG;
    }

    protected var context: Context
    protected var cols = 0
    protected var rows = 0
    var id = 0
    var level = 0
    private var gameMode: GameMode
    var nPuzzlePortions: List<NPuzzlePortion>

    protected constructor(applicationContext: Context, gameMode: GameMode){
        this. id = 1
        this.level = 2
        this.context = applicationContext
        setRowsAndCols(level)
        this.gameMode = gameMode
        this.nPuzzlePortions = createNPuzzlePortions()
    }

    protected fun setRowsAndCols(level: Int){
        when(level) {
            1 -> {this.cols = 2; this.rows = 3}
            2 -> {this.cols = 4; this.rows = 6}
            3 -> {this.cols = 8; this.rows = 12}
        }
    }

    protected abstract fun createNPuzzlePortions(): List<NPuzzlePortion>
}