package com.example.mvvmecommercecompseapp.store.domain.model


data class ImgurResponse(
    val data: List<GalleryItem>,
    val success: Boolean,
    val status: Int
)

data class GalleryItem(
    val id: String,
    val title: String?,
    val datetime: Long?,
    val cover: String?,
    val cover_width: Int?,
    val cover_height: Int?,
    val account_url: String?,
    val views: Int,
    val link: String,
    val ups: Int?,
    val downs: Int?,
    val points: Int?,
    val score: Int?,
    val is_album: Boolean,
    val images_count: Int?,
    val images: List<Image>?
)

data class Image(
    val id: String,
    val title: String?,
    val description: String?,
    val datetime: Long,
    val type: String,
    val animated: Boolean,
    val width: Int,
    val height: Int,
    val size: Int,
    val views: Int,
    val link: String
)

