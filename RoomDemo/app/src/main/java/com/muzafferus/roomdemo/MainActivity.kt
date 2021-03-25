package com.muzafferus.roomdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.muzafferus.roomdemo.databinding.ActivityMainBinding
import com.muzafferus.roomdemo.db.SubscriberDatabase
import com.muzafferus.roomdemo.db.SubscriberRepository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SubscriberViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(
            this,
            SubscriberViewModelFactory(
                SubscriberRepository(
                    SubscriberDatabase.getInstance(application).subscriberDao
                )
            )
        ).get(SubscriberViewModel::class.java)

        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        displaySubscriberList()
    }

    private fun displaySubscriberList() {
        viewModel.subscribers.observe(this, Observer {
            Log.e("YER", "it: ${it.toString()}")
        })
    }
}