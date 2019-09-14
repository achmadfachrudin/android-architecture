package com.project.framework.core


@Suppress("DataClassPrivateConstructor")
data class NetworkState private constructor(
    val status: Status,
    val exception: Exception? = null
) {
    companion object {
        val LOADED = NetworkState(Status.SUCCESS)
        val EMPTY = NetworkState(Status.EMPTY)
        val LOADING = NetworkState(Status.RUNNING)
        fun error(exception: Exception?) = NetworkState(Status.FAILED, exception)
    }

    enum class Status {
        RUNNING,
        SUCCESS,
        EMPTY,
        FAILED
    }
}