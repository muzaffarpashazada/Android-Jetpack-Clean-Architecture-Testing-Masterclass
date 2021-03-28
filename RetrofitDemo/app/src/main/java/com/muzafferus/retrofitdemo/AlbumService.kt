package com.muzafferus.retrofitdemo

import retrofit2.Response
import retrofit2.http.*

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(
    ): Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbumById(
        @Path("id") albumsId: Int
    ): Response<AlbumItem>

    @GET("/albums")
    suspend fun getStoredAlbums(
        @Query("userId") userId: Int
    ): Response<Albums>

    @POST("/albums")
    suspend fun uploadAlbum(
        @Body album: AlbumItem
    ): Response<AlbumItem>
}