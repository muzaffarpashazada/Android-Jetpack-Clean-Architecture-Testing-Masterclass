package com.muzafferus.workmagaerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class DownloadingWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            for (i in 0..3) {
                Log.e("YER", "Downloading $i")
            }

            val time = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
            val currentlyData = time.format(Date())
            Log.e("YER", "Completed $currentlyData")

            Result.success()
        } catch (exception: Exception) {
            exception.printStackTrace()
            Result.failure()
        }
    }
}