package com.muzafferus.roomdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muzafferus.roomdemo.databinding.ActivityMainBinding
import com.muzafferus.roomdemo.db.Subscriber
import com.muzafferus.roomdemo.db.SubscriberDatabase
import com.muzafferus.roomdemo.db.SubscriberRepository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SubscriberViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(application).subscriberDao
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
        initRecyclerView()

        viewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let { message ->
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecyclerView() {
        binding.subscriberRecyclerView.layoutManager = LinearLayoutManager(this)
        displaySubscribersList()
    }

    private fun displaySubscribersList() {
        viewModel.subscribers.observe(this, Observer {
            binding.subscriberRecyclerView.adapter =
                MyRecyclerViewAdapter(it) { selectedItem: Subscriber -> listItemClicked(selectedItem) }

        })
    }

    private fun listItemClicked(subscriber: Subscriber) {
        viewModel.initUpdateOrDelete(subscriber)
    }
}