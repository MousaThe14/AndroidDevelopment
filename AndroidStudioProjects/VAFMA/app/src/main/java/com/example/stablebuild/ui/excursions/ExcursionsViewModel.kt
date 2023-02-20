package com.example.vafma.ui.VAFMAd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is excursions Fragment"
    }
    val text: LiveData<String> = _text
}