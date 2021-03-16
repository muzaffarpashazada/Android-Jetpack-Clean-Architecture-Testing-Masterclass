package com.anushka.coroutinesdemo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }

        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                tvUserMessage.text = UserDataManager().getTotalUserCount().toString()
            }
        }
    }

    private suspend fun downloadUserData() {
        withContext(Dispatchers.Main) {
            for (i in 1..20000) {
                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
                delay(10)
            }
        }
    }
}
