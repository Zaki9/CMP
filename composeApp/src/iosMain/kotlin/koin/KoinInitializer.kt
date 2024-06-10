package koin

import appModule
import database.ArticlesDataBase
import database.getPeopleDatabase
import org.koin.core.context.startKoin
import org.koin.dsl.module

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(
                appModule,
                viewModelModule,
                module {
                    single<ArticlesDataBase> {
                        getPeopleDatabase()
                    }
                }
            )
        }
    }
}