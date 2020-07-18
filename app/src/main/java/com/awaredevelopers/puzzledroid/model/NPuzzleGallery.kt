package com.awaredevelopers.puzzledroid.model

import android.Manifest
import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.PermissionChecker
import androidx.core.content.PermissionChecker.checkSelfPermission
import com.awaredevelopers.puzzledroid.utility.ImageUtil.getListImageSliced
import com.awaredevelopers.puzzledroid.utility.NPuzzlePortion
import com.google.android.material.internal.ContextUtils.getActivity
import org.slf4j.IMarkerFactory
import java.security.AccessControlContext
import java.security.AccessController.getContext

class NPuzzleGallery(applicationContext: Context): NPuzzle(applicationContext, GameMode.RANDOM_GALLERY_IMG) {

    override fun createNPuzzlePortions(): List<NPuzzlePortion> {


        setRowsAndCols(3)
        return getListImageSliced(bmp, cols, rows)
    }


    companion object {


        //Gallery image
        lateinit var bmp: Bitmap;


    }





}


