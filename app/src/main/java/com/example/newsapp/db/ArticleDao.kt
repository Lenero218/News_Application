package com.example.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.models.Article


@Dao
interface ArticleDao {

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun upsert(article : Article): Long //update or insert a new article

@Query("Select * from articles") //
fun getAllArticles() : LiveData<List<Article>>

@Delete
suspend fun deleteArticle(article: Article)

}