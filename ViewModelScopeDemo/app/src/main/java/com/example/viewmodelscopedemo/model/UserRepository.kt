package com.example.viewmodelscopedemo.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUserData(): List<User> {
        delay(8000)
        return listOf(
            User(1, "Sam"),
            User(2, "Jerry"),
            User(3, "Tom"),
            User(4, "John")
        )
    }
}