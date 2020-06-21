package com.awaredevelopers.puzzledroid.model

import android.content.Context
import android.graphics.BitmapFactory
import com.awaredevelopers.puzzledroid.utility.ImageUtil.getListImageSliced
import com.awaredevelopers.puzzledroid.utility.NPuzzlePortion

class NPuzzleGallery(applicationContext: Context): NPuzzle(applicationContext, GameMode.RANDOM_GALLERY_IMG) {

    override fun createNPuzzlePortions(): List<NPuzzlePortion> {
        setRowsAndCols(3)
        val bmp = BitmapFactory.decodeStream(
            context.assets.open("preloaded_npuzzle_img/ny_west_44th_street.jpg")
        )
        return getListImageSliced(bmp, cols, rows)
    }
}