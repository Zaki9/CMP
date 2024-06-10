package koin

import android.content.Context
import appModule
import com.jetbrains.greeting.database.getPeopleDatabase
import database.ArticlesDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

actual class KoinInitializer(
    private val context: Context
) {
    actual fun init() {
        startKoin {
            androidContext(context)
            modules(
                appModule,
                viewModelModule,
                module {
                    single<ArticlesDataBase> {
                        getPeopleDatabase(context)
                    }
                }
            )
        }
    }
}