package com.example.challange1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..20000) {
                Log.e("Muzafferus", "this is ${Thread.currentThread().name} -  $i")
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            for (i in 1..20000) {
                Log.e("Muzafferus", "this is  ${Thread.currentThread().name} -  $i")
            }
        }
    }
}