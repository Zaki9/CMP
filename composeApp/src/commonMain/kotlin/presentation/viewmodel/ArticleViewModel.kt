package presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.usecase.GetArticleListUseCase
import data.model.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import presentation.state.ArticleItemViewState

class ArticleViewModel(
    private val articleUseCase: GetArticleListUseCase
) : ViewModel() {
    val mNewsArticleState = MutableStateFlow<ArticleItemViewState>(ArticleItemViewState.Loading)

    fun fetchArticles() {

        viewModelScope.launch {
            val result = articleUseCase.execute(Unit)
            when (result) {
                is Result.Error -> {
                    mNewsArticleState.value =
                        ArticleItemViewState.Error(
                            result.error.toString()
                        )

                }

                is Result.Success -> {
                    mNewsArticleState.value =
                        ArticleItemViewState.ArticleLoaded(result.data.articles)

                }
            }
        }
    }
}