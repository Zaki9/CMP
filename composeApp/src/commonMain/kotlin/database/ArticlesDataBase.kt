package database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ArticleDB::class],
    version = 1
)
abstract class ArticlesDataBase : RoomDatabase(), DB {
    abstract fun articleDao(): ArticleDao
    override fun clearAllTables() {
        super.clearAllTables()
    }
}

// FIXME: Added a hack to resolve below issue:
// Class 'AppDatabase_Impl' is not abstract and does not implement abstract base class member 'clearAllTables'.
interface DB {
    fun clearAllTables() {}
}