package com.muzafferus.motionlayoutdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        motion_layout.transitionToStart()

        GlobalScope.launch (Dispatchers.IO){
            delay(100)
            withContext(Dispatchers.Main){
                motion_layout.transitionToEnd()
            }
        }
    }
}