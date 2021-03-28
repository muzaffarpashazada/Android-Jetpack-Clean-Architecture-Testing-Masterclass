package com.muzafferus.retrofitdemo

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(
    ): Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbumById(
        @Path(value = "id") albumsId: Int
    ): Response<AlbumItem>

    @GET("/albums")
    suspend fun getStoredAlbums(
        @Query("userId") userId: Int
    ): Response<Albums>
}