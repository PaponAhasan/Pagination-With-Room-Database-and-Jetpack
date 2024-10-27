package com.example.paginationwithroom.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paginationwithroom.data.dao.PostsDao
import com.example.paginationwithroom.data.entity.Post

@Database(
    entities = [Post::class],
    version = 1
)
abstract class PostsDatabase : RoomDatabase() {
    abstract val postsDao: PostsDao

    companion object {
        const val DATABASE_NAME = "posts-db"
    }
}