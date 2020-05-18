package com.awaredevelopers.puzzledroid.utils

import android.graphics.Bitmap

object CreateImageSliced {

    fun createImageSliced(bmp: Bitmap): MutableMap<String, Bitmap> {

        val mutableMap: MutableMap<String, Bitmap> = mutableMapOf<String, Bitmap>()

        // Number of rows and columns
        var col = 4
        var row = 6

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
}