package com.example.paginationwithroom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paginationwithroom.data.entity.Post
import com.example.paginationwithroom.domain.paging.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
): ViewModel() {

    val postsPagingData: Flow<PagingData<Post>> =
        getPostsUseCase
            .invoke()
            .cachedIn(viewModelScope)
}