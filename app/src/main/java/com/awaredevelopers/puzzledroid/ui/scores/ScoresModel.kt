package com.awaredevelopers.puzzledroid.ui.scores

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoresModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is SCORES Fragment"
    }
    val text: LiveData<String> = _text
}