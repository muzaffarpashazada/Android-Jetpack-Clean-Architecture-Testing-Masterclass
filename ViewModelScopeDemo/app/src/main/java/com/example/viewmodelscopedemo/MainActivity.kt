package com.example.viewmodelscopedemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewMode: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewMode = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewMode.users.observe(this, Observer { myUsers ->
            myUsers.forEach {
                Log.e("Yer", "$it")
            }
        })
        mainActivityViewMode.getUserData()
    }
}