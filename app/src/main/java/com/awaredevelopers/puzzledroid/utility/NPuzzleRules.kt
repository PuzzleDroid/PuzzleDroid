package com.awaredevelopers.puzzledroid.utility

import android.util.Log

object NPuzzleRules {
    private val TAG = "NPuzzleRules"

    fun getEmptySpace(position: Int, list: List<NPuzzlePortion>): Int {
        var numCols = list[position].numCols
        var right = true
        var left = true
        var top = true
        var bottom = true

        if(list[position].id == -1){
            return position
        }
        if(position < numCols){
            Log.d(TAG, "Estamos arriba")
            top = false
        }
        if((position + 1)%numCols == 0){
            Log.d(TAG, "Estamos a la derecha")
            right = false
        }
        if(position == 0 || position%numCols == 0){
            Log.d(TAG, "Estamos a la izquierda")
            left = false
        }
        if(!(list.size >= position + 1 && position + 1 <= (list.size - numCols))) {
            Log.d(TAG, "Estamos abajo")
            bottom = false
        }

        if (right && list[position + 1].id == -1) {
            return position + 1
        }
        if (left && list[position - 1].id == -1) {
            return position - 1
        }
        if (bottom && list[position + numCols].id == -1) {
            return position + numCols
        }
        if (top && list[position - numCols].id == -1) {
            return position - numCols
        }
        return position
    }
    fun isCorrectOrder(list: List<NPuzzlePortion>): Boolean {
        for (i in 0 until list.size - 1) {
                //DEBUG
            if(list[0].id == 0){
                return true
//            if (list[i].id == i) {
//                Log.d(TAG, "Pieza " + list[i].id + " en orden correcto")
//                if (i == list.size - 2) {
//                    return true
//                }
            } else {
                break
            }
        }
        return false
    }
}