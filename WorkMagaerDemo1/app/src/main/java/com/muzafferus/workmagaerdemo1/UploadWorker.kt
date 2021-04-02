package com.muzafferus.workmagaerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class UploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    companion object {
        const val KEY_WORKER = "key_worker"
    }

    override fun doWork(): Result {
        return try {
            val count = inputData.getInt(MainActivity.KEY_COUNT_VALUE, 10000)
            for (i in 0 until count) {
                Log.e("YER", "Uploading $i")
            }

            val time = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
            val currentlyData = time.format(Date())

            val outputData = Data.Builder()
                .putString(KEY_WORKER, currentlyData)
                .build()

            Result.success(outputData)
        } catch (exception: Exception) {
            exception.printStackTrace()
            Result.failure()
        }
    }
}