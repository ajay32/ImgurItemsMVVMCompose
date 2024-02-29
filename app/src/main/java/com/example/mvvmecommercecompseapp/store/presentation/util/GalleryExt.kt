package com.example.mvvmecommercecompseapp.store.presentation.util

import com.example.mvvmecommercecompseapp.store.domain.model.GalleryItem

fun GalleryItem.extractImageUrl(): String {
    // If it's an album, attempt to use the first image in the images list
    if (this.is_album && !this.images.isNullOrEmpty()) {
        return this.images.first().link
    }
    return this.link // Fallback to using the 'link' field
}
