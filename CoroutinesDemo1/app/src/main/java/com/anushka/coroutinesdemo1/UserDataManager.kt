package com.anushka.coroutinesdemo1

import kotlinx.coroutines.*

class UserDataManager {
    suspend fun getTotalUserCount():Int {
        var count   = 0
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 66
        }

        val defered = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 666
        }
        return count + defered.await()
    }
}