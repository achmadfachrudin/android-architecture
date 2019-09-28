package com.project.data.service

import com.project.data.entities.menu.Menu
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface MainService {
    @GET("5d7f91dc3300003c56f0b3fa")
    fun getMenuAsync(): Deferred<Response<Menu>>
}