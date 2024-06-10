package database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Upsert
    suspend fun upsertArticle(article: ArticleDB)

    @Query("SELECT DISTINCT * FROM ArticleDB")
    fun fetchArticleDB(): Flow<List<ArticleDB>>

    @Query("SELECT (SELECT COUNT(*) FROM ArticleDB) == 0")
    suspend fun isArticleDbEmpty(): Boolean
}