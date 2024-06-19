package data.model

data class ArticleListModel(
    val articles: List<ArticleItemModel>
)

data class ArticleItemModel(
    val title: String,
    val desc: String,
    val imgUrl: String,
    val publishDate: String
)
