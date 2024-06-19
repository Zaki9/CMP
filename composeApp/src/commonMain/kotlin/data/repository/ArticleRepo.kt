package data.repository

import data.model.ArticleListModel
import data.model.Result
import data.model.RootError
interface ArticleRepo {
    suspend fun fetchArticles(): Result<ArticleListModel, RootError>
}
