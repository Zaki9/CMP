import androidx.compose.ui.window.ComposeUIViewController
import koin.KoinInitializer

fun MainViewController() = ComposeUIViewController(configure = {
    KoinInitializer().init()
}) { App() }