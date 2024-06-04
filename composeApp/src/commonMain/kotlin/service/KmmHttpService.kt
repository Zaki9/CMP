package service

import article.ArticleResponse
import com.jetbrains.greeting.BuildKonfig.API_KEY
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class KmmHttpService(private val httpClient: HttpClient) {

    private val mApiKey = API_KEY

    suspend fun fetchArticlesService(): ArticleResponse {
        return httpClient.get("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=$mApiKey")
            .body()
    }
}