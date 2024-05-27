package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import article.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import repository.DataRepository

class BaseViewModel(private val mDataRepository: DataRepository) : ViewModel() {
    val mNewsArticleState = MutableStateFlow(listOf<Article>())
    fun fetchNewsArticles() {
        viewModelScope.launch {
            mDataRepository.fetchArticlesRepo().collectLatest {
                mNewsArticleState.value = it
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}