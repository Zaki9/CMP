import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import presentation.view.ArticleComposable
import presentation.viewmodel.ArticleViewModel
import utils.koinInjectViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            val mViewModel = koinInjectViewModel<ArticleViewModel>()
            val mArticleState = mViewModel.mNewsArticleState.collectAsState()
            ArticleComposable(mViewModel, mArticleState)
        }
    }
}
