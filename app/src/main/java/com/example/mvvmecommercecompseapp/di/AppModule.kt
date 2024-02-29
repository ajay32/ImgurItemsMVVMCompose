package com.example.mvvmecommercecompseapp.di

import com.example.mvvmecommercecompseapp.store.data.remote.GalleryItemsApi
import com.example.mvvmecommercecompseapp.util.Constant.BASES_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideGalleryItemsApi() : GalleryItemsApi {
        return Retrofit.Builder()
            .baseUrl(BASES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GalleryItemsApi::class.java)
    }
}