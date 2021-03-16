package com.anushka.asyncawaitdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(IO).launch {
            Log.e("Muzafferus", "Calculation prosses started...")
            val firstStock = getFirstStock()
            val secondStock = getSecondStock()
            val total = firstStock + secondStock
            Log.e("Muzafferus", "Total is $total")
        }

    }
}

private suspend fun getFirstStock(): Int {
    delay(10000)
    Log.e("Muzafferus", "first stock returned")
    return 55000
}

private suspend fun getSecondStock(): Int {
    delay(8000)
    Log.e("Muzafferus", "second stock returned")
    return 35000
}