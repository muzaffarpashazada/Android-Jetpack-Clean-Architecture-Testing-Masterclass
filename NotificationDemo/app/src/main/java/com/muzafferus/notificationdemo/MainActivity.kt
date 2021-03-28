package com.muzafferus.notificationdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val channelId = "com.muzafferus.notificationdemo.channel1"
    private var notificationManager: NotificationManager? = null
    private val KEY_REPLY = "key_reply"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelId, "DemoChannel", "this is a demo notification channel")


        button.setOnClickListener {
            displayNotification()
        }
    }

    private fun displayNotification() {
        val notificationId = 45

        val tapResultIntent = Intent(this, SecondActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                tapResultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )

        //reply action
        val remoteInput: RemoteInput = RemoteInput.Builder(KEY_REPLY).run {
            setLabel("Insert your name here")
            build()
        }

        val replyAction: NotificationCompat.Action = NotificationCompat.Action.Builder(
                0,
                "Reply",
                pendingIntent).addRemoteInput(remoteInput)
                .build()

        //action button details
        val intentDetails = Intent(this, DetailsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingDetails = PendingIntent.getActivity(
                this,
                0,
                intentDetails,
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        val actionDetails: NotificationCompat.Action = NotificationCompat.Action.Builder(0, "Details", pendingDetails).build()

        //action button settings
        val intentSetting = Intent(this, SettingsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingSetting = PendingIntent.getActivity(
                this,
                0,
                intentSetting,
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        val actionSetting: NotificationCompat.Action = NotificationCompat.Action.Builder(0, "Settings", pendingSetting).build()

        val notification = NotificationCompat.Builder(this@MainActivity, channelId)
                .setContentTitle("Demo Title")
                .setContentText("This is demo notification")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .addAction(actionDetails)
                .addAction(actionSetting)
                .addAction(replyAction)
                .build()
        notificationManager?.notify(notificationId, notification)
    }

    private fun createNotificationChannel(id: String, name: String, channelDescription: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).apply {
                description = channelDescription
            }
            notificationManager?.createNotificationChannel(channel)
        }
    }
}