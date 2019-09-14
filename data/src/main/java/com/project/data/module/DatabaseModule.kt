package com.project.data.module

import androidx.room.Room
import com.project.data.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 1-Jun-19
 */
val databaseModule = module {

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "app-db")
            .build()
    }

    single { get<AppDatabase>().numberDAO() }
}