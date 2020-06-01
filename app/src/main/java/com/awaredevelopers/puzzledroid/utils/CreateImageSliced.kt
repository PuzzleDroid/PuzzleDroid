package com.awaredevelopers.puzzledroid.utils

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable


object CreateImageSliced {

    fun getMapImageSliced(bmp: Bitmap): Map<String, Bitmap> {

        val mutableMap: MutableMap<String, Bitmap> = mutableMapOf<String, Bitmap>()

        // Number of rows and columns
        val col = 4
        val row = 6

        // Image total width and total height
        val tWidth = bmp.width
        val tHeight = bmp.height
        println("Image Dimension: $tWidth x $tHeight")

        // Width and height of each piece
        val eWidth = tWidth / col
        val eHeight = tHeight / row

        // Initial coordinates
        var x = 0
        var y = 0

        for (i in 0 until row) {
            y = 0
            for (j in 0 until col) {
                println("Creating piece: $i$j")
                mutableMap["$i$j"] = Bitmap.createBitmap(bmp, y, x, eWidth, eHeight)
                y += eWidth
            }
            x += eHeight
        }
        return mutableMap
    }

    fun getListImageSliced(bmp: Bitmap): List<NPuzzlePortion> {

        val nPuzzle: MutableList<NPuzzlePortion> = ArrayList<NPuzzlePortion>()

        val level = 1 //TODO Obtener el nivel como parámetro. El lvl debe tenerlo la clase NPuzzle

        // Number of rows and columns
        var cols = 0
        var rows = 0
        when(level) {
            1 -> {cols = 2; rows = 3}
            2 -> {cols = 4; rows = 6}
            3 -> {cols = 8; rows = 12}
        }

        // Image total width and total height
        val tWidth = bmp.width
        val tHeight = bmp.height
        println("Image Dimension: $tWidth x $tHeight")

        // Width and height of each piece
        val eWidth = tWidth / cols
        val eHeight = tHeight / rows

        // Initial coordinates
        var x = 0
        var y = 0

        var count = 0

        for (i in 0 until rows) {
            y = 0

            for (j in 0 until cols) {
                println("Creating piece: $i$j")
                val drawable = BitmapDrawable(
                    Bitmap.createBitmap(bmp, y, x, eWidth, eHeight)
                )
                val nPuzzlePortion = NPuzzlePortion(
                    id = count,
                    coord = Coordinates(j+1,i+1),
                    numCols = cols,
                    numRows = rows,
                    level = level,
                    drawable = drawable
                )
                nPuzzle.add(nPuzzlePortion)
                count += 1
                y += eWidth
            }
            x += eHeight
        }
        return nPuzzle
    }
}
class Coordinates(var x: Int, var y: Int){
    override fun toString(): String { return "( $x, $y)" }
}
class NPuzzlePortion(val id:Int, val coord: Coordinates, var numCols: Int, var numRows: Int, val level: Int, val drawable: Drawable) {
    constructor(): this(
       -1, Coordinates(-1,-1),-1,-1,-1, ColorDrawable(Color.TRANSPARENT)
    )
    override fun toString(): String { return "ID: $id \n( x, y): $coord \nCols: $numCols, Rows: $numRows \nLevel: $level"
    }
}