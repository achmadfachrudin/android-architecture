package com.project.data.entities.favorite

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by achmad.fachrudin on 1-Jun-19
 */
@Dao
interface NumberDAO {

    /**
     * Save all entities
     */
    @Insert
    fun saveAll(entitiesList: List<Number>)

    /**
     * Save one entities
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNumber(entities: Number)

    /**
     * Find Number for given id
     * @return Number
     */
    @Query("SELECT * FROM numberFavorite WHERE id = :id")
    fun findNumberById(id: String): Number
}