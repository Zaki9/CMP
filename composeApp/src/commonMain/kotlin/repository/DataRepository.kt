package repository

import article.Article
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import service.KmmHttpService

class DataRepository(private val mKmmHttpService: KmmHttpService) {
    suspend fun fetchArticlesRepo(): Flow<List<Article>> = flow {
        try {
            val resp = mKmmHttpService.fetchArticlesService().articles
            emit(resp)
        } catch (e: Exception) {
            Napier.e("Error", e)
        }
    }
}