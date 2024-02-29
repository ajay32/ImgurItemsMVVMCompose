package com.example.mvvmecommercecompseapp.store.domain

data class NetworkError(
    val error : ApiError,
    val statusCode: Int? = null,
    val t : Throwable? = null

) {
    override fun toString(): String {
        return if (statusCode != null) {
            "${error.message}: Code $statusCode"
        } else {
            error.message
        }
    }
}

enum class ApiError(val message: String) { //static
    NetworkError("Network Error"),
    AuthorizationError("Authorization Error"),
    HttpError("HTTP Error"),
    UnknownResponse("Unknown Response"),
    UnknownError("Unknown Error");
}
