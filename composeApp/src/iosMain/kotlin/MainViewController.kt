import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController(configure = {
    KoinIntitializer().init()
}) { App() }