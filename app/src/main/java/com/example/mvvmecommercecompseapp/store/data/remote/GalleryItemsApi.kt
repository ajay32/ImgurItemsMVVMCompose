package com.example.mvvmecommercecompseapp.store.data.remote

import com.example.mvvmecommercecompseapp.store.domain.model.ImgurResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface GalleryItemsApi {

    @GET("gallery/search/{sort}/{window}/{page}")
    suspend fun searchGallery(
        @Header("Authorization") authorization: String,
        @Path("sort") sort: String = "top",
        @Path("window") window: String = "week",
        @Path("page") page: Int = 0,
        @Query("q") query: String) : ImgurResponse

}