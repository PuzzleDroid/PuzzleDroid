package com.awaredevelopers.puzzledroid.utility

import android.util.Log
import com.awaredevelopers.puzzledroid.utility.IS_DEBUG


object NPuzzleRules {
    private val TAG = "NPuzzleRules"

    fun getEmptySpace(position: Int, list: List<NPuzzlePortion>): Int {
        var numCols = list[position].numCols
        var isRight = false
        var isLeft = false
        var isTop = false
        var isBottom = false

        if(list[position].id == -1){
            return position
        }
        if(position < numCols){
            Log.d(TAG, "Estamos arriba")
            isTop = true
        }
        if((position + 1)%numCols == 0){
            Log.d(TAG, "Estamos a la derecha")
            isRight = true
        }
        if(position == 0 || position%numCols == 0){
            Log.d(TAG, "Estamos a la izquierda")
            isLeft = true
        }
        if(!(list.size >= position + 1 && position + 1 <= (list.size - numCols))) {
            Log.d(TAG, "Estamos abajo")
            isBottom = true
        }

        if (!isRight && list[position + 1].id == -1) {
            return position + 1
        }
        if (!isLeft && list[position - 1].id == -1) {
            return position - 1
        }
        if (!isBottom && list[position + numCols].id == -1) {
            return position + numCols
        }
        if (!isTop && list[position - numCols].id == -1) {
            return position - numCols
        }
        return position
    }
    fun isCorrectOrder(list: List<NPuzzlePortion>): Boolean {
        if(IS_DEBUG) {
            if(list[0].id == 0) return true
        } else {
            for (i in 0 until list.size - 1) {
                if (list[i].id == i) {
                    Log.d(TAG, "Pieza " + list[i].id + " en orden correcto")
                    if (i == list.size - 2) {
                        return true
                    }
                } else {
                    break
                }
            }
        }
        return false
    }
}