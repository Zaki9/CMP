package data.repository

import data.model.ArticleListModel
import data.mapper.ArticleMapper
import data.model.NetworkError
import data.model.Result
import data.model.RootError
import data.service.KmmHttpService

class ArticleRepoImpl(
    private val mKmmHttpService: KmmHttpService
) : ArticleRepo {
    override suspend fun fetchArticles(): Result<ArticleListModel, RootError> {

        val resp = mKmmHttpService.fetchArticlesService().articles
        return if (resp.isNotEmpty()) {
            Result.Success(
                data = ArticleMapper().mapFrom(resp)
            )
        } else {
            Result.Error(error = NetworkError.NOT_AUTHENTICATED)
        }
    }
}