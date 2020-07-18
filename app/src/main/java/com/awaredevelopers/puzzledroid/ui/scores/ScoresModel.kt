package com.awaredevelopers.puzzledroid.ui.scores

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.awaredevelopers.puzzledroid.db.AppDatabase
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity

class ScoresModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is SCORES Fragment"
    }
    val text: LiveData<String> = _text
}