package com.project.data.entities.favorite

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by achmad.fachrudin on 1-Jun-19
 */
@Entity(tableName = "numberFavorite")
data class Number(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val numberFavorite: String
)