package com.jetbrains.greeting.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.ArticlesDataBase

fun getPeopleDatabase(context: Context): ArticlesDataBase {
    val dbFile = context.getDatabasePath("article.db")
    return Room.databaseBuilder<ArticlesDataBase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    ).setDriver(BundledSQLiteDriver()).build()
}