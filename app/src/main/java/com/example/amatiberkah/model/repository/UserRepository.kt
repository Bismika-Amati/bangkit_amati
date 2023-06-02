package com.example.amatiberkah.model.repository

import com.example.amatiberkah.model.local.UserPreferences
import com.example.amatiberkah.model.remote.api.ApiService
import com.example.amatiberkah.model.remote.api.AppExecutors
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class UserRepository(
    private val apiService: ApiService,
    private val userPreferences: UserPreferences,
    appExecutors: AppExecutors
) {

    private val diskDispatcher = appExecutors.diskIO.asCoroutineDispatcher()
    private val networkDispatcher = appExecutors.networkIO.asCoroutineDispatcher()

    suspend fun loginStudent(email: String, password: String) = flow {
        emit(
            apiService.loginStudent(
                email, password
            )
        )
    }.flowOn(networkDispatcher)

    suspend fun loginAdmin(email: String, password: String) = flow {
        emit(
            apiService.loginAdmin(
                email, password
            )
        )
    }.flowOn(networkDispatcher)

    suspend fun saveToken(token: String) {
        return withContext(diskDispatcher) {
            userPreferences.saveUserToken(token)
        }
    }

    fun getToken(): Flow<String?> {
        return userPreferences.getUserToken()
    }

    fun isLoggedin(): Flow<Boolean> {
        return userPreferences.getUserToken().map { token ->
            token != null
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserRepository? = null
        fun getInstance(apiService: ApiService, userPreference: UserPreferences, appExecutor: AppExecutors): UserRepository {
            return INSTANCE ?: synchronized(this) {
                val instance = UserRepository(apiService, userPreference, appExecutor )
                INSTANCE = instance
                instance
            }
        }
    }
}