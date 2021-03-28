package com.muzafferus.retrofitdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var retService: AlbumService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

//        getRequestWithPathParam()
//        getRequestWithQueryParam()
        updateAlbum()
    }

    private fun getRequestWithPathParam() {
        val pathResponse: LiveData<Response<AlbumItem>> = liveData {
            val response = retService.getAlbumById(2)
            emit(response)
        }
        pathResponse.observe(this, Observer {
            val album = it.body()
            if (album != null) {
                Toast.makeText(this, "Title: ${album.title}", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun getRequestWithQueryParam() {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retService.getStoredAlbums(2)
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

    private fun updateAlbum() {
        val album = AlbumItem(0, "My title", 66)
        val postResponse: LiveData<Response<AlbumItem>> = liveData {
            val response = retService.uploadAlbum(album)
            emit(response)
        }

        postResponse.observe(this, Observer {
            val receivedAlbumItem = it.body()

            receivedAlbumItem?.let {
                val result = " " + "Album Title :  ${receivedAlbumItem.title}" + "\n" +
                        " " + "Album id : ${receivedAlbumItem.id}" + "\n" +
                        " " + "Album userId : ${receivedAlbumItem.userId}" + "\n\n\n"
                textView.append(result)
            }

        })
    }

}