package com.example.paginationwithroom.domain

import androidx.paging.PagingSource
import com.example.paginationwithroom.data.entity.Post
import kotlinx.coroutines.flow.Flow

interface PostsRepository {

    fun getPosts(): PagingSource<Int, Post>

    fun getById(id: Int): Flow<Post>

    suspend fun savePosts(posts: List<Post>)
}