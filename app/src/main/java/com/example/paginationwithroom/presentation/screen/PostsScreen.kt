package com.example.paginationwithroom.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.paginationwithroom.data.entity.Post
import com.example.paginationwithroom.presentation.viewmodel.PostsViewModel

@Composable
fun PostsScreen(
    modifier: Modifier,
    viewModel: PostsViewModel = hiltViewModel(),
) {
    val postsLazyPagingItems: LazyPagingItems<Post> = viewModel.postsPagingData.collectAsLazyPagingItems()

    PostsList(
        postsLazyPagingItems = postsLazyPagingItems,
        modifier = modifier
    )
}


@Composable
fun PostsList(
    modifier: Modifier,
    postsLazyPagingItems: LazyPagingItems<Post>
) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(
            count = postsLazyPagingItems.itemCount,
            key = postsLazyPagingItems.itemKey { it.id?:-1 },
            contentType = postsLazyPagingItems.itemContentType { "Links" }
        ) { index: Int ->

            val post: Post? = postsLazyPagingItems[index]
            post?.let {
                PostView(it)
            }

        }
    }

}

@Composable
fun PostView(post: Post) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = post.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}