package com.project.data.service

import com.project.data.entities.menu.Menu
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET


interface MainService {
    @GET("5d10dfe030000060484ca2f7")
    fun getMenuAsync(): Deferred<Response<Menu>>
}