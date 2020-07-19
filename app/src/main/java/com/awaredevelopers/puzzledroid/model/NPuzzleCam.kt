package com.awaredevelopers.puzzledroid.model

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import com.awaredevelopers.puzzledroid.utility.ImageUtil
import com.awaredevelopers.puzzledroid.utility.ImageUtil.getListImageSliced
import com.awaredevelopers.puzzledroid.utility.NPuzzlePortion

class NPuzzleCam(applicationContext: Context, bmp: Bitmap): NPuzzle( applicationContext, GameMode.CAM_PICTURE_IMG, bmp) {

    override fun createNPuzzlePortions(): List<NPuzzlePortion> {
        setRowsAndCols(1)
        return getListImageSliced(ImageUtil.scaleCenterCrop(bitmap), cols, rows)
    }

}


