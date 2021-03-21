package com.example.lifecycledemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.lifecycledemo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        lifecycleScope.launch(Dispatchers.IO) {
            Log.e("Muzafferus", "Thread is ${Thread.currentThread().name}")
        }

        lifecycleScope.launchWhenCreated {
            Log.e("Muzafferus", "Thread is launchWhenCreated and ${Thread.currentThread().name}")
        }

        lifecycleScope.launchWhenStarted {
            Log.e("Muzafferus", "Thread is launchWhenStarted and ${Thread.currentThread().name}")
        }

        lifecycleScope.launchWhenResumed {
            Log.e("Muzafferus", "Thread is launchWhenResumed and ${Thread.currentThread().name}")
        }
    }

}