package com.awaredevelopers.puzzledroid.model

import android.content.Context
import android.graphics.Bitmap
import com.awaredevelopers.puzzledroid.utility.ImageUtil
import com.awaredevelopers.puzzledroid.utility.ImageUtil.getListImageSliced
import com.awaredevelopers.puzzledroid.utility.NPuzzlePortion

class NPuzzleGallery(applicationContext: Context, bmp: Bitmap) : NPuzzle(
    applicationContext, GameMode.RANDOM_GALLERY_IMG, bmp) {

    override fun createNPuzzlePortions(): List<NPuzzlePortion> {
        setRowsAndCols(2)
        return getListImageSliced(ImageUtil.scaleCenterCrop(bitmap), cols, rows)
    }
}


