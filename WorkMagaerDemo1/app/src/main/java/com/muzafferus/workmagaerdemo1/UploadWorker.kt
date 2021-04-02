package com.muzafferus.workmagaerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            Log.e("YER", "Uploading Start!")

            for (i in 0..100) {
                Log.e("YER", "Uploading $i%")
            }
            Log.e("YER", "Uploading Finish!")

            Result.success()
        } catch (exception: Exception) {
            exception.printStackTrace()
            Result.failure()
        }
    }
}