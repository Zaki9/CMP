package service

import article.ArticleResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class KmmHttpService(private val httpClient: HttpClient) {

    private val mApiKey ="f67ace1b27b24ce4b95c7f71fde88920"

    suspend fun fetchArticlesService(): ArticleResponse {
        return httpClient.get("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=$mApiKey")
            .body()
    }
}