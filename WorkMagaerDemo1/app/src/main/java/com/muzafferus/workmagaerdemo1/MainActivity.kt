package com.muzafferus.workmagaerdemo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uploadButton.setOnClickListener {
            setOnTimeWorkRequest()
        }
    }

    private fun setOnTimeWorkRequest() {
        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java).build()
        WorkManager.getInstance(applicationContext)
            .enqueue(uploadRequest)
    }
}