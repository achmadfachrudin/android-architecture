package com.project.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.ashokvarma.gander.Gander
import com.ashokvarma.gander.imdb.GanderIMDB
import com.project.app.module.*
import com.project.data.module.databaseModule
import com.project.data.module.networkModule
import com.project.data.module.repositoryModule
import com.project.data.PrefManager
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PrefManager.init(this)

        /* gander */
        Gander.setGanderStorage(GanderIMDB.getInstance())

        /* koin */
        startKoin {
            androidContext(this@BaseApplication)
            androidLogger()
            modules(listOf(networkModule, repositoryModule, databaseModule))
            modules(featureModule)
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}