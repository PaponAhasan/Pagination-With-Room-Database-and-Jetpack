package com.example.paginationwithroom.domain.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paginationwithroom.data.entity.Post
import com.example.paginationwithroom.domain.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postsRepository: PostsRepository
) {
    operator fun invoke(): Flow<PagingData<Post>> {
        return Pager(
            PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
            )
        ) {
            postsRepository.getPosts()
        }.flow
    }
}