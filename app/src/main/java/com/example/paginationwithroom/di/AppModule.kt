package com.example.paginationwithroom.di

import android.app.Application
import androidx.room.Room
import com.example.paginationwithroom.data.database.PostsDatabase
import com.example.paginationwithroom.domain.PostsRepository
import com.example.paginationwithroom.domain.PostsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(
        app: Application
    ): PostsDatabase {
        return Room.databaseBuilder(
            app,
            PostsDatabase::class.java,
            PostsDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePostsRepository(
        postsDatabase: PostsDatabase
    ): PostsRepository {
        return PostsRepositoryImpl(postsDatabase.postsDao)
    }
}