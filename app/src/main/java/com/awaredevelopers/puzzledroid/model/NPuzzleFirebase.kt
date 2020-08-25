package com.awaredevelopers.puzzledroid.model

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.awaredevelopers.puzzledroid.utility.ImageUtil
import com.awaredevelopers.puzzledroid.utility.ImageUtil.getListImageSliced
import com.awaredevelopers.puzzledroid.utility.NPuzzlePortion
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class NPuzzleFirebase(applicationContext: Context, bmp: Bitmap): NPuzzle( applicationContext, GameMode.FIREBASE_IMG, bmp) {
    override fun createNPuzzlePortions(): List<NPuzzlePortion> {
        return getListImageSliced(ImageUtil.scaleCenterCrop(bitmap), cols, rows)
    }

    /**
    override fun createNPuzzlePortions(): List<NPuzzlePortion> {
        var storage = FirebaseStorage.getInstance("gs://puzzledroid-fadc9.appspot.com")
        var listRef = storage.getReference()
        var result = ArrayList<String>()
        val bmp = BitmapFactory.decodeStream(
            context.assets.open("preloaded_npuzzle_img/ny_west_44th_street.jpg")
        )

        suspend fun getImages(listRef: StorageReference): ArrayList<String> {
            return suspendCoroutine { continuation ->
                val list = listRef.listAll()

                list.addOnSuccessListener { listResult ->
                    listResult.items.forEach { item ->
                        result.add(item.name)
                    }

                    continuation.resume(result)
                }

                list.addOnFailureListener {
                    it
                }

                continuation.resume(result)
            }
        }

        GlobalScope.launch(Dispatchers.Main) {
            launch ( coroutineContext ) {
                getImages(listRef)
            }.join()

            run {
                val bmp = BitmapFactory.decodeStream(
                    context.assets.open("preloaded_npuzzle_img/ny_west_44th_street.jpg")
                )

                getListImageSliced(bmp, cols, rows)
            }
        }

        return getListImageSliced(bmp, cols, rows)
    }
    */
}