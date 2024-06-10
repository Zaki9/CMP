package repository

import database.ArticleDB
import database.ArticlesDataBase
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import service.KmmHttpService

class DataRepository(
    private val mKmmHttpService: KmmHttpService,
    private val articlesDataBase: ArticlesDataBase
) {
    suspend fun fetchArticlesRepo(): Flow<List<ArticleDB>> {
        return try {
            if (articlesDataBase.articleDao().isArticleDbEmpty()) {
                val resp = mKmmHttpService.fetchArticlesService().articles
                resp.forEach {
                    articlesDataBase.articleDao().upsertArticle(
                        ArticleDB(
                            title = it.title,
                            desc = it.description,
                            publishDate = it.publishedAt,
                            imgUrl = it.urlToImage
                        )
                    )
                }
            }
            articlesDataBase.articleDao().fetchArticleDB()
        } catch (e: Exception) {
            Napier.e("Error", e)
            flowOf()
        }
    }
}