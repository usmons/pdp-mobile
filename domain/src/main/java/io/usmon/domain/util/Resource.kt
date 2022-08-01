package io.usmon.domain.util

import kotlinx.coroutines.flow.Flow
import java.io.Serializable

// Created by Usmon Abdurakhmanv on 7/31/2022.

class Resource<T> private constructor(
    private val state: State<T>,
) : Serializable {

    val isLoading: Boolean get() = state is State.Loading

    val isFailed: Boolean get() = state is State.Failure

    val isSucceed: Boolean get() = state is State.Success

    override fun toString(): String =
        when (state) {
            is State.Loading -> "Loading..."
            is State.Failure -> "Failure(${state.message})"
            is State.Success -> "Success(${state.data})"
        }

    companion object {

        fun <T> success(data: T, message: String? = null): Resource<T> {
            return Resource(
                State.Success(data, message)
            )
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(
                State.Loading(data)
            )
        }

        fun <T> failure(message: String, data: T? = null): Resource<T> {
            return Resource(
                State.Failure(message, data)
            )
        }
    }

    private sealed class State<T>(val data: T? = null, val message: String? = null) {
        class Success<T>(data: T, message: String? = null) : State<T>(data, message)
        class Failure<T>(message: String, data: T? = null) : State<T>(data, message)
        class Loading<T>(data: T? = null) : State<T>(data)
    }

    fun getErrorMessage(): String? = state.message

    fun getData(): T? = state.data
}

suspend inline fun <reified T> Flow<Resource<T>>.collectAsResource(
    crossinline loading: (data: T?) -> Unit = {},
    crossinline failed: (message: String, data: T?) -> Unit = { _, _ -> },
    crossinline succeed: (data: T) -> Unit = {},
) {
    this.collect { result ->
        if (result.isLoading) {
            loading(result.getData())
        } else if (result.isFailed) {
            failed(result.getErrorMessage()!!, result.getData())
        } else {
            succeed(result.getData()!!)
        }
    }
}