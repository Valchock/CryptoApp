package com.example.cryptoapp.domain

sealed class Result<T>(val status: Status, val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Result<T>(Status.SUCCESS, data)
    class Error<T>(message: String, data: T? = null) : Result<T>(Status.ERROR, data, message)
    class Loading<T>(val isLoading: Boolean = true) : Result<T>(Status.LOADING, null)
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}
