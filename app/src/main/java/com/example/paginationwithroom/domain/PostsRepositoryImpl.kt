package com.example.paginationwithroom.domain

import androidx.paging.PagingSource
import com.example.paginationwithroom.data.dao.PostsDao
import com.example.paginationwithroom.data.entity.Post
import kotlinx.coroutines.flow.Flow

class PostsRepositoryImpl(
    private val postsDao: PostsDao
)
: PostsRepository {
    override fun getPosts(): PagingSource<Int, Post> {
        return postsDao.getPosts()
    }

    override fun getById(id: Int): Flow<Post> {
        return postsDao.getById(id)
    }

    override suspend fun savePosts(posts: List<Post>) {
        return postsDao.savePosts(posts)
    }
}