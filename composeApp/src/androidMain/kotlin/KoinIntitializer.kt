import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

actual class KoinIntitializer(
    private val context: Context
) {

    actual fun init() {
        startKoin {
            androidContext(context)
            modules(
                appModule, viewModelModule
            )
        }
    }
}