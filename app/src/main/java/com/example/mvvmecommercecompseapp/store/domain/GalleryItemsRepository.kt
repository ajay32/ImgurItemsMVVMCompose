package com.example.mvvmecommercecompseapp.store.domain

import arrow.core.Either
import com.example.mvvmecommercecompseapp.store.domain.model.GalleryItem

interface GalleryItemsRepository {
    suspend fun searchGallery(query: String) : Either<NetworkError, List<GalleryItem>>
}