package com.awaredevelopers.puzzledroid.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.awaredevelopers.puzzledroid.FooJava
import com.awaredevelopers.puzzledroid.MainActivity
import com.google.firebase.firestore.FirebaseFirestore




class HomeViewModel : ViewModel() {

    //TODO Quitar esta instancia a Firebase...
    var db = FirebaseFirestore.getInstance()

    private val _text = MutableLiveData<String>().apply {

        var objectJava = FooJava("pos un string", 12, true, FooJava.RANDOMDES.DES1)
        value = objectJava.toString()
    }
    val text: LiveData<String> = _text

}