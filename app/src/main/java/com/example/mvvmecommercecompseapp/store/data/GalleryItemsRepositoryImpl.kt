package com.example.mvvmecommercecompseapp.store.data

import arrow.core.Either
import com.example.mvvmecommercecompseapp.BuildConfig
import com.example.mvvmecommercecompseapp.store.data.mapper.toNetworkError
import com.example.mvvmecommercecompseapp.store.data.remote.GalleryItemsApi
import com.example.mvvmecommercecompseapp.store.domain.NetworkError
import com.example.mvvmecommercecompseapp.store.domain.GalleryItemsRepository
import com.example.mvvmecommercecompseapp.store.domain.model.GalleryItem
import javax.inject.Inject

class GalleryItemsRepositoryImpl @Inject constructor(private val productsApi: GalleryItemsApi) : GalleryItemsRepository {
    override suspend fun searchGallery(query: String): Either<NetworkError, List<GalleryItem>> {
        return Either.catch {
            val clientId = BuildConfig.IMGUR_CLIENT_ID
            val authorizationHeaderValue = "Client-ID $clientId"
            val response = productsApi.searchGallery(authorizationHeaderValue, query = query)
            response.data
        }.mapLeft {
            it.toNetworkError()
        }
    }

}

