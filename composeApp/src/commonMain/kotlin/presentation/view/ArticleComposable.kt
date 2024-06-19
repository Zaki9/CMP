package presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import data.model.ArticleItemModel
import presentation.state.ArticleItemViewState
import presentation.viewmodel.ArticleViewModel
import utils.toFormattedDate

@Composable
fun ArticleComposable(
    mViewModel: ArticleViewModel,
    mArticleState: State<ArticleItemViewState>
) {
    LaunchedEffect(Unit) {
        mViewModel.fetchArticles()
    }

    when (mArticleState.value) {
        is ArticleItemViewState.ArticleLoaded -> {
            LazyColumn(Modifier.fillMaxWidth().padding(16.dp)) {
                (mArticleState.value as ArticleItemViewState.ArticleLoaded).list.forEach {
                    item {
                        ArticleRow(it)
                    }
                }
            }
        }

        is ArticleItemViewState.Error -> {
            TextCenter("Error")
        }

        ArticleItemViewState.Loading -> {
            TextCenter("Loading")
        }
    }
}

@Composable
private fun TextCenter(message: String) {
    Box(Modifier.fillMaxSize().background(Color.Transparent)) {
        Text(modifier = Modifier.align(Alignment.Center), text = message)
    }
}

@Composable
private fun ArticleRow(it: ArticleItemModel) {
    Column {
        AsyncImage(
            it.imgUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().padding(4.dp)
        )
        Spacer(Modifier.height(4.dp))
        Text(
            it.title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        )
        Spacer(Modifier.height(4.dp))
        Text(it.desc)
        Spacer(Modifier.height(4.dp))
        Text(
            it.publishDate.toFormattedDate(),
            modifier = Modifier.align(Alignment.End),
            style = TextStyle(
                color = Color.Gray
            )
        )
    }
}