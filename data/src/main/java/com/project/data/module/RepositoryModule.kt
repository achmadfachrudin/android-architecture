package com.project.data.module

import com.project.data.repository.FavoriteRepository
import com.project.data.repository.FavoriteRepositoryImpl
import com.project.data.repository.MainRepository
import com.project.data.repository.MainRepositoryImpl
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 1-Jun-19
 */
val repositoryModule = module {

    /* api */
    single<MainRepository> { MainRepositoryImpl(service = get()) }

    /* database */
    single<FavoriteRepository> { FavoriteRepositoryImpl(dao = get()) }
}