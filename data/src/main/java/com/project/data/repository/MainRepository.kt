package com.project.data.repository

import com.project.data.entities.menu.Menu
import com.project.data.service.MainService
import kotlinx.coroutines.Deferred
import retrofit2.Response

/**
 * Repository to provide a MainService
 */
interface MainRepository {
    fun getMenuAsync(): Deferred<Response<Menu>>
}

class MainRepositoryImpl(private val service: MainService) : MainRepository {
    override fun getMenuAsync() = service.getMenuAsync()
}