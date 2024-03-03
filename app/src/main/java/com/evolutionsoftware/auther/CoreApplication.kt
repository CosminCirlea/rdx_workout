package com.evolutionsoftware.auther

import android.app.Application

class CoreApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinModules.startKoin(this)
    }
}