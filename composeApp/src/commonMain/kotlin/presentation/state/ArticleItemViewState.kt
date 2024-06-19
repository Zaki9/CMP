package presentation.state

import data.model.ArticleItemModel

sealed class ArticleItemViewState {

    object Loading : ArticleItemViewState()
    data class ArticleLoaded(val list: List<ArticleItemModel>) : ArticleItemViewState()
    data class Error(val error: String) : ArticleItemViewState()
}
