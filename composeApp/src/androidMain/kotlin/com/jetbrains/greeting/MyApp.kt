package com.jetbrains.greeting

import KoinIntitializer
import android.app.Application

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinIntitializer(applicationContext).init()
    }
}