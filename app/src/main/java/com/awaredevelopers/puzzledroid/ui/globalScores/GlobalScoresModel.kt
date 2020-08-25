package com.awaredevelopers.puzzledroid.ui.globalScores

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GlobalScoresModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is SCORES Fragment"
    }
    val text: LiveData<String> = _text
}