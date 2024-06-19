package koin

import data.repository.ArticleRepoImpl
import domain.usecase.GetArticleListUseCase
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import presentation.viewmodel.ArticleViewModel
import data.service.KmmHttpService

val appModule = module {
    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }
    single { KmmHttpService(get()) }
    single { ArticleRepoImpl(get()) }
    single { GetArticleListUseCase(get()) }
    single { ArticleViewModel(get()) }
}