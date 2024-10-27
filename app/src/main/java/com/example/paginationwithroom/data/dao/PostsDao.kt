package com.example.paginationwithroom.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paginationwithroom.data.entity.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostsDao {
    @Query("SELECT * FROM posts")
    // getAll(): Flow<List<Post>>
    fun getPosts(): PagingSource<Int, Post>

    @Query("SELECT * FROM posts WHERE id = :id")
    fun getById(id: Int): Flow<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePosts(posts: List<Post>)
}