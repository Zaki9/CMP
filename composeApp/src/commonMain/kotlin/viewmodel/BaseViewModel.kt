package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import article.Article
import article.Source
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import repository.DataRepository

class BaseViewModel(private val mDataRepository: DataRepository) : ViewModel() {
    val mNewsArticleState = MutableStateFlow(listOf<Article>())
    fun fetchNewsArticles() {
        viewModelScope.launch {
            mDataRepository.fetchArticlesRepo().collectLatest {
                mNewsArticleState.value = it.map {
                    Article(
                        title = it.title,
                        description = it.desc,
                        publishedAt = it.publishDate,
                        urlToImage = it.imgUrl,
                        url = "",
                        source = Source("", ""),
                        author = "",
                        content = ""
                    )
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}