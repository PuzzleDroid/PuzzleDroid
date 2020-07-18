package com.awaredevelopers.puzzledroid.model

import android.content.Context
import android.graphics.BitmapFactory
import com.awaredevelopers.puzzledroid.utility.ImageUtil.getListImageSliced
import com.awaredevelopers.puzzledroid.utility.NPuzzlePortion
import java.util.*

class NPuzzlePreloaded(applicationContext: Context): NPuzzle(applicationContext, GameMode.PRELOADED_IMG) {

    override fun createNPuzzlePortions(): List<NPuzzlePortion> {
        var givenList = context.assets.list("preloaded_npuzzle_img")?.toMutableList()
        if (givenList != null) {
            returnRandomElementsNoRepeat(givenList)
        }
        super.imgName = givenList!![0].toString()
//        val bmp = BitmapFactory.decodeStream(
//            context.assets.open("preloaded_npuzzle_img/${givenList!![0].toString()}")
//        )
        val bmp = BitmapFactory.decodeStream(
            context.assets.open("preloaded_npuzzle_img/ny_west_44th_street.jpg")
        )
        return getListImageSliced(bmp, cols, rows)
    }

    private fun returnRandomElementsNoRepeat(givenList: MutableList<String>) {
        val rand = Random()
        for (i in 0 until givenList.size - 1) {
            val randomIndex: Int = rand.nextInt(givenList.size)
            val randomElement = givenList[randomIndex]
            givenList.removeAt(randomIndex)
        }
    }
}