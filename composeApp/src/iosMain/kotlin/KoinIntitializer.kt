import org.koin.core.context.startKoin

actual class KoinIntitializer {

    actual fun init() {
        startKoin {
            modules(
                appModule, viewModelModule
            )
        }
    }
}