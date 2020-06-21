package com.awaredevelopers.puzzledroid.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is SETTINGS Fragment"
    }
    val text: LiveData<String> = _text
}