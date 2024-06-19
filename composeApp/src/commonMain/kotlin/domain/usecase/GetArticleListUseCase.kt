package domain.usecase

import data.model.ArticleListModel
import data.repository.ArticleRepoImpl
import data.model.Result
import data.model.RootError

class GetArticleListUseCase(
    private val articleRepo: ArticleRepoImpl
) : UseCase<Unit, Result<ArticleListModel, RootError>> {
    override suspend fun execute(input: Unit): Result<ArticleListModel, RootError> {
        return articleRepo.fetchArticles()
    }
}