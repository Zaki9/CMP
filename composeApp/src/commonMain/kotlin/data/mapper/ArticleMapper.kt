package data.mapper

import data.model.Article
import data.model.ArticleItemModel
import data.model.ArticleListModel

class ArticleMapper() : Mapper<List<Article>, ArticleListModel> {
    override fun mapFrom(from: List<Article>): ArticleListModel {
        return ArticleListModel(from.map {
            ArticleItemModel(
                title = it.title,
                desc = it.description,
                imgUrl = it.urlToImage,
                publishDate = it.publishedAt
            )
        })
    }
}