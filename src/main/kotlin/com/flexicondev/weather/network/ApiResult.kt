package com.flexicondev.weather.network

sealed class ApiResult<out T : Any> {
    data class Success<out T : Any>(val value: T) : ApiResult<T>()
    data class Error(val message: String, val cause: Exception? = null) : ApiResult<Nothing>()
}
