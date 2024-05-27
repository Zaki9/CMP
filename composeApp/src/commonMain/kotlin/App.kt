import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import article.Article
import coil3.compose.AsyncImage
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import utils.koinInjectViewModel
import utils.toFormattedDate
import viewmodel.BaseViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            val mViewModel = koinInjectViewModel<BaseViewModel>()
            val mArticleList = mViewModel.mNewsArticleState.collectAsState()
            LaunchedEffect(Unit) {
                mViewModel.fetchNewsArticles()
            }

            LazyColumn(Modifier.fillMaxWidth().padding(16.dp)) {
                mArticleList.value.forEach {
                    item {
                        ArticleRow(it)
                    }
                }
            }
        }
    }
}

@Composable
private fun ArticleRow(it: Article) {
    Column {
        AsyncImage(
            it.urlToImage,
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
        Text(it.description)
        Spacer(Modifier.height(4.dp))
        Text(
            it.publishedAt.toFormattedDate(),
            modifier = Modifier.align(Alignment.End),
            style = TextStyle(
                color = Color.Gray
            )
        )
    }
}