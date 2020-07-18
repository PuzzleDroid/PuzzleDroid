package com.awaredevelopers.puzzledroid.utility

object TimeUtil {
    fun millisec2hhmmss(milliseconds: Long): String {
        val seconds = (milliseconds / 1000) % 60
        val minutes = (milliseconds / (1000 * 60) % 60)
        val hours = (milliseconds / (1000 * 60 * 60) % 24)
        return "${hours.toString().padStart(2, '0')}:" +
                "${minutes.toString().padStart(2, '0')}:" +
                "${seconds.toString().padStart(2, '0')}"
    }
}

