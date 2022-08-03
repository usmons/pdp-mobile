package io.usmon.domain.util

import kotlinx.coroutines.flow.Flow
import java.io.Serializable

// Created by Usmon Abdurakhmanv on 7/31/2022.

typealias SimpleResource = Resource<Unit>

sealed class Resource<T> private constructor(
    val data: T? = null,
    val message: String? = null,
) : Serializable {

    class Success<T>(data: T, message: String? = null) : Resource<T>(data, message)
    class Failure<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)

    override fun toString(): String =
        when (this) {
            is Loading -> "Loading..."
            is Failure -> "Failure(${message})"
            is Success -> "Success(${data})"
        }

    companion object {

        fun <T> success(data: T, message: String? = null): Resource<T> {
            return Success(data, message)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Loading(data)
        }

        fun <T> failure(message: String, data: T? = null): Resource<T> {
            return Failure(message, data)
        }
    }
}

suspend inline fun <reified T> Flow<Resource<T>>.collectAsResource(
    crossinline loading: (data: T?) -> Unit = { },
    crossinline failed: (message: String, data: T?) -> Unit = { _, _ -> },
    crossinline succeed: (data: T) -> Unit = { },
) {
    this.collect { result ->
        when (result) {
            is Resource.Loading -> {
                loading(result.data)
            }
            is Resource.Failure -> {
                failed(result.message!!, result.data)
            }
            is Resource.Success -> {
                succeed(result.data!!)
            }
        }
    }
}