package com.muzafferus.tmdbclient.presentation.artist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.muzafferus.tmdbclient.R
import com.muzafferus.tmdbclient.databinding.ActivityArtistBinding
import com.muzafferus.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel

    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            Log.e("YER", "$it")
        })
    }
}