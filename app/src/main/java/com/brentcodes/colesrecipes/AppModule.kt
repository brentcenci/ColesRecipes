package com.brentcodes.colesrecipes

import android.content.Context
import com.brentcodes.colesrecipes.data.ColesRepository
import com.brentcodes.colesrecipes.data.ColesRepositoryImpl
import com.brentcodes.colesrecipes.data.JsonFileReader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(@ApplicationContext context: Context): ColesRepository {
        return ColesRepositoryImpl(context, JsonFileReader)
    }
}