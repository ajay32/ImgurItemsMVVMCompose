package com.example.mvvmecommercecompseapp.store.data.mapper


import retrofit2.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.mvvmecommercecompseapp.store.domain.ApiError
import com.example.mvvmecommercecompseapp.store.domain.NetworkError
import java.io.IOException





fun Throwable.toNetworkError(): NetworkError {
    val apiError = when (this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> {
            when (code()) {
                403 -> ApiError.AuthorizationError
                else -> ApiError.HttpError
            }
        }
        else -> ApiError.UnknownError
    }
    val statusCode = (this as? HttpException)?.code()
    return NetworkError(apiError, statusCode,this)
}
