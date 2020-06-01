package com.awaredevelopers.puzzledroid.utility

import com.awaredevelopers.puzzledroid.utils.NPuzzlePortion

object NPuzzleRules {
    fun getEmptySpace(position: Int, list: List<NPuzzlePortion>, numCols: Int): Int {
        var right = true;
        var left = true;
        var top = true;
        var bottom = true;

        if(list[position].id == -1){
            return position
        }
        if(position < numCols){
            top = false
        }
        if((position + 1)%numCols == 0){
            right = false
        }
        if(position == 0 || position%numCols == 0){
            left = false
        }
        if(!(list.size >= position + 1 && position + 1 <= (list.size - numCols))) {
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
    fun getCorrectorder(list: List<NPuzzlePortion>): Boolean {
        for (i in 0 until list.size - 1) {
            if (list[i].id == i) {
                println("Pieza " + list[i].id + " en orden correcto")
                if (i == list.size - 2) {
                    return true
                }
            } else {
                return false
            }
        }
        return false
    }
}