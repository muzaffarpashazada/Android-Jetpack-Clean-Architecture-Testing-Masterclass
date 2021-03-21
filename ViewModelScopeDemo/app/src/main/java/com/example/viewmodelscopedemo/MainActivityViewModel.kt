package com.example.viewmodelscopedemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.viewmodelscopedemo.model.UserRepository
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel : ViewModel() {

    private var userRepository = UserRepository()

    var users = liveData(Dispatchers.IO) {
        val result = userRepository.getUserData()
        emit(result)
    }

}