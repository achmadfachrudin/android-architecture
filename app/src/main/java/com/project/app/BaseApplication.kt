package com.project.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.project.framework.util.PrefManager


class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PrefManager.init(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}