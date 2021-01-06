package com.example.onelabhw1.view_model_sample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {

    val liveData = MutableLiveData<String>()

    fun setLiveData(s: String) {
        liveData.value = s
    }
}