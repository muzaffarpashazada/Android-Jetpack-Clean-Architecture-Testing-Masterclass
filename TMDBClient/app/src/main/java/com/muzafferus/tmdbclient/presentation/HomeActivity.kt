package com.muzafferus.tmdbclient.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.muzafferus.tmdbclient.R
import com.muzafferus.tmdbclient.presentation.artist.ArtistActivity
import com.muzafferus.tmdbclient.presentation.movie.MovieActivity
import com.muzafferus.tmdbclient.presentation.tvshow.TvShowActivity
import com.muzafferus.tmdbclient.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        initSetOnCLick()
    }

    private fun initSetOnCLick() {
        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.artistButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)

        }

        binding.tvShowButton.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }
    }
}