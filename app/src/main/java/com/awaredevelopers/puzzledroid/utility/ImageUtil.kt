package com.awaredevelopers.puzzledroid.utility

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF
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

    fun scaleCenterCrop(source: Bitmap): Bitmap {
        val newHeight = 1308
        val newWidth = 872
        val sourceWidth = source.width
        val sourceHeight = source.height

        // Compute the scaling factors to fit the new height and width, respectively.
        // To cover the final image, the final scaling will be the bigger
        // of these two.
        val xScale = newWidth.toFloat() / sourceWidth
        val yScale = newHeight.toFloat() / sourceHeight
        val scale = xScale.coerceAtLeast(yScale)

        // Now get the size of the source bitmap when scaled
        val scaledWidth = scale * sourceWidth
        val scaledHeight = scale * sourceHeight

        // Let's find out the upper left coordinates if the scaled bitmap
        // should be centered in the new size give by the parameters
        val left = (newWidth - scaledWidth) / 2
        val top = (newHeight - scaledHeight) / 2

        // The target rectangle for the new, scaled version of the source bitmap will now
        // be
        val targetRect = RectF(left, top, left + scaledWidth, top + scaledHeight)

        // Finally, we create a new bitmap of the specified size and draw our new,
        // scaled bitmap onto it.
        val dest = Bitmap.createBitmap(newWidth, newHeight, source.config)
        val canvas = Canvas(dest)
        canvas.drawBitmap(source, null, targetRect, null)
        return dest
    }

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
                        drawable = drawable,
                        eWidth = eWidth.toFloat(),
                        eHeight = eHeight.toFloat()
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
class NPuzzlePortion(
    val id:Int,
    val coord: Coordinates,
    var numCols: Int,
    var numRows: Int,
    val drawable: Drawable,
    val eWidth: Float,
    val eHeight: Float) {
    constructor(): this(
       -1,

        Coordinates(-1, -1),-1,-1, ColorDrawable(Color.TRANSPARENT), 0f, 0f
    )
    override fun toString(): String { return "ID: $id \n( x, y): $coord \nCols: $numCols, Rows: $numRows"
    }
}