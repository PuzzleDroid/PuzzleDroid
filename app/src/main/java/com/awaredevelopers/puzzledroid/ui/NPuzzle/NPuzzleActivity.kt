package com.awaredevelopers.puzzledroid.ui.NPuzzle

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.utils.CreateImageSliced
import com.bumptech.glide.Glide
import java.io.ByteArrayOutputStream


class NPuzzleActivity : AppCompatActivity() {

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_npuzzle)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val imageView: ImageView = findViewById<View>(R.id.myImageView) as ImageView
        var bmp = BitmapFactory.decodeStream(assets.open("cities_img/ny_west_44th_street.jpg"))
        var mutableMap = CreateImageSliced.createImageSliced(bmp)

        Glide.with(this).load(mutableMap["23"])
            .into(imageView)

    }

    private fun saveImage(drawable:Int, title:String): Uri {
        // Get the image from drawable resource as drawable object
        val drawable = ContextCompat.getDrawable(applicationContext,drawable)

        // Get the bitmap from drawable object
        val bitmap = (drawable as BitmapDrawable).bitmap

        // Save image to gallery
        val savedImageURL = MediaStore.Images.Media.insertImage(
            contentResolver,
            bitmap,
            title,
            "Image of $title"
        )

        // Parse the gallery image url to uri
        return Uri.parse(savedImageURL)
    }
}
