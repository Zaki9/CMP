package database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleDB(
    @PrimaryKey val title: String,
    val desc: String,
    val imgUrl: String,
    val publishDate: String
)
