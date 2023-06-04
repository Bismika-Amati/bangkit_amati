package com.example.amatiberkah.model.repository

import com.example.amatiberkah.model.remote.api.ApiServiceAuth

class UserRepository(
    private val apiService: ApiServiceAuth
) {

    companion object {
        @Volatile
        private var INSTANCE: UserRepository? = null
        fun getInstance(apiService: ApiServiceAuth): UserRepository {
            return INSTANCE ?: synchronized(this) {
                val instance = UserRepository(apiService)
                INSTANCE = instance
                instance
            }
        }
    }
}