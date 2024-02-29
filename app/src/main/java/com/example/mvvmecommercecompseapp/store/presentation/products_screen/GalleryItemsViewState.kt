package com.example.mvvmecommercecompseapp.store.presentation.products_screen

import com.example.mvvmecommercecompseapp.store.domain.model.GalleryItem

data class GalleryItemsViewState(
    val isLoading : Boolean = false,
    val galleryItemList : List<GalleryItem> = emptyList(),
    val error : String? = null
)
