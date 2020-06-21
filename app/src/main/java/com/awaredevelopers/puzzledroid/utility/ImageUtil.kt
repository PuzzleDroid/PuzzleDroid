package com.awaredevelopers.puzzledroid.utility

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import com.awaredevelopers.puzzledroid.ui.nPuzzle.NPuzzleActivity

/**
 * Single static instance to help us to manipulate the provided image.
 */
object ImageUtil {

    private const val TAG = "NPuzzleSlicer"

    @Suppress("DEPRECATION")
    fun getListImageSliced(bmp: Bitmap, cols: Int, rows: Int): List<NPuzzlePortion> {

        val nPuzzle: MutableList<NPuzzlePortion> = ArrayList()

        // Image total width and total height
        val tWidth = bmp.width
        val tHeight = bmp.height
        Log.d(TAG, "Image Dimension: $tWidth x $tHeight")

        // Width and height of each piece
        val eWidth = tWidth / cols
        val eHeight = tHeight / rows

        // Initial coordinates
        var x = 0
        var y: Int

        var count = 0

        for (i in 0 until rows) {
            y = 0

            for (j in 0 until cols) {
                Log.d(TAG, "Creating piece: #${count+1} (${i+1},${j+1})")
                val drawable = BitmapDrawable(
                    Bitmap.createBitmap(bmp, y, x, eWidth, eHeight)
                )
                val nPuzzlePortion =
                    NPuzzlePortion(
                        id = count,
                        coord = Coordinates(
                            j + 1,
                            i + 1
                        ),
                        numCols = cols,
                        numRows = rows,
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
class Coordinates(private var x: Int, private var y: Int){
    override fun toString(): String { return "( $x, $y)" }
}
class NPuzzlePortion(val id:Int, val coord: Coordinates, var numCols: Int, var numRows: Int, val drawable: Drawable) {
    constructor(): this(
       -1,
        Coordinates(-1, -1),-1,-1, ColorDrawable(Color.TRANSPARENT)
    )
    override fun toString(): String { return "ID: $id \n( x, y): $coord \nCols: $numCols, Rows: $numRows"
    }
}