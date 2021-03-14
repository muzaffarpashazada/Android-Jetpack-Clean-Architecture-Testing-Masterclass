package com.example.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {

    private var total = MutableLiveData<Int>()
    val totalData: LiveData<Int>
        get() = total

    val inputText = MutableLiveData<String>()

    init {
        total.postValue(startingTotal)
    }

    fun addTotal() {
        val inputInteger: Int? = inputText.value?.toIntOrNull()
        inputInteger?.let {
            total.value = (total.value)?.plus(it)
        }
    }

}