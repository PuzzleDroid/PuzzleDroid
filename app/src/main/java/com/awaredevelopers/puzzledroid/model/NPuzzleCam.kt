package com.awaredevelopers.puzzledroid.model

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import com.awaredevelopers.puzzledroid.utility.ImageUtil.getListImageSliced
import com.awaredevelopers.puzzledroid.utility.NPuzzlePortion

class NPuzzleCam(applicationContext: Context): NPuzzle(applicationContext, GameMode.CAM_PICTURE_IMG) {

    override fun createNPuzzlePortions(): List<NPuzzlePortion> {


        openCamera()
        return getListImageSliced(bmp, cols, rows)
    }
    companion object {
        lateinit var imageCamera : Uri

        //Permission code
        private val REQUEST_CAMERA= 1002

        lateinit var bmp : Bitmap
    }


        private fun openCamera(){

        /*    val values = ContentValues()
            values.put(MediaStore.Images.Media.TITLE, "New Picture")
            values.put(MediaStore.Images.Media.DESCRIPTION, "From the camera")
            imageCamera = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)!!*/

            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageCamera)
            startActivityForResult(cameraIntent,REQUEST_CAMERA, Bundle.EMPTY)

        }


        //handle result of picked image
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (resultCode == Activity.RESULT_OK) {

                 bmp = BitmapFactory.decodeFile(data?.data.toString())
            }
        }
    }


