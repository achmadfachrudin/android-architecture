package com.project.data.repository

import com.project.data.entities.favorite.Number
import com.project.data.entities.favorite.NumberDAO

/**
 * Repository to provide a NumberDAO
 */
interface FavoriteRepository {
    fun saveAll(entitiesList: List<Number>)
    fun saveNumber(entities: Number)
    fun findNumberById(id: String): Number
}

class FavoriteRepositoryImpl(private val dao: NumberDAO) : FavoriteRepository {
    override fun saveAll(entitiesList: List<Number>) = dao.saveAll(entitiesList)

    override fun saveNumber(entities: Number) = dao.saveNumber(entities)

    override fun findNumberById(id: String) = dao.findNumberById(id)
}