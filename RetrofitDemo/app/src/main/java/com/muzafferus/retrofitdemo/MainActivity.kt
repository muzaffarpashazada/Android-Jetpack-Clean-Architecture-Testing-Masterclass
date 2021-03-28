package com.muzafferus.retrofitdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitService: AlbumService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retrofitService.getStoredAlbums(2)
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumListItem = albumList.next()
                    val result = " " + "Album Title :  ${albumListItem.title}" + "\n" +
                            " " + "Album id : ${albumListItem.id}" + "\n" +
                            " " + "Album userId : ${albumListItem.userId}" + "\n\n\n"

                    textView.append(result)
                }
            }
        })
    }
}