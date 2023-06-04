package com.example.amatiberkah.model.di

import com.example.amatiberkah.model.remote.api.ApiConfig
import com.example.amatiberkah.model.remote.api.ApiServiceAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideApiServiceAuth(): ApiServiceAuth {
        return ApiConfig.getApiServiceAuth()
    }
}