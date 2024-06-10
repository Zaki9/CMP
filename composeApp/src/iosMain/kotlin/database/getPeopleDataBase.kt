package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

fun getPeopleDatabase(): ArticlesDataBase {
    val dbFile = NSHomeDirectory() + "/article.db"
    return Room.databaseBuilder<ArticlesDataBase>(
        name = dbFile,
        factory = { ArticlesDataBase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver()).build()
}