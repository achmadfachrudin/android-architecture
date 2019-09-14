package com.project.data.database

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.data.entities.favorite.Number
import com.project.data.entities.favorite.NumberDAO

/**
 * Created by achmad.fachrudin on 1-Jun-19
 */
@Database(entities = [Number::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun numberDAO(): NumberDAO
}