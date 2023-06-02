package com.example.amatiberkah.model.di

import android.content.Context
import com.example.amatiberkah.model.local.UserPreferences
import com.example.amatiberkah.model.local.dataStore
import com.example.amatiberkah.model.remote.api.ApiConfig
import com.example.amatiberkah.model.remote.api.AppExecutors
import com.example.amatiberkah.model.repository.UserRepository

object Injection {
    fun provideUserRepository(context: Context): UserRepository {
        val apiService = ApiConfig.getApiService()
        val userPreference = UserPreferences.getInstance(context.dataStore)
        val appExecutor = AppExecutors()
        return UserRepository.getInstance(apiService, userPreference, appExecutor)
    }
}