package com.muzafferus.tmdbclient.presentation.tvshow

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.muzafferus.tmdbclient.R
import com.muzafferus.tmdbclient.databinding.ActivityTvShowBinding
import com.muzafferus.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel

    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)

        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            Log.e("YER", "$it")
        })
    }
}
