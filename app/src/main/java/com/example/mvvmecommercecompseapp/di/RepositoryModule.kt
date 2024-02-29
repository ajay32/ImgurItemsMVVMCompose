package com.example.mvvmecommercecompseapp.di

import com.example.mvvmecommercecompseapp.store.data.GalleryItemsRepositoryImpl
import com.example.mvvmecommercecompseapp.store.domain.GalleryItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsGalleryItemRepository(impl : GalleryItemsRepositoryImpl) : GalleryItemsRepository
}