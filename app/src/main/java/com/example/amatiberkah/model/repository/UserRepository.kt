package com.example.amatiberkah.model.repository

import com.example.amatiberkah.model.remote.api.ApiService

class UserRepository(
    private val apiService: ApiService
) {

    companion object {
        @Volatile
        private var INSTANCE: UserRepository? = null
        fun getInstance(apiService: ApiService): UserRepository {
            return INSTANCE ?: synchronized(this) {
                val instance = UserRepository(apiService)
                INSTANCE = instance
                instance
            }
        }
    }
}