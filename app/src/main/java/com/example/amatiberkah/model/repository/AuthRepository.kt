package com.example.amatiberkah.model.repository

import com.example.amatiberkah.model.local.UserPreferences
import com.example.amatiberkah.model.remote.api.ApiServiceAuth
import com.example.amatiberkah.model.remote.response.LoginResponse
import com.example.amatiberkah.model.remote.response.LoginResponseDataUser
import com.example.amatiberkah.model.remote.response.RegisterResponse
import com.example.amatiberkah.utils.handleError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiServiceAuth: ApiServiceAuth,
    private val userPreferences: UserPreferences
) {


    suspend fun registerByRole(
        fullName: String,
        email: String,
        password: String,
        role: String,
        phoneNumber: String,
        photo: String?,
        provinceId: String?,
        cityId: String?,
        districtId: String?,
        subDistrictId: String?,
        postcode: String?,
        address: String?,
    ): Flow<Result<RegisterResponse>> {
        return flow {
            val response = apiServiceAuth.registerByRole(
                fullName,
                email,
                password,
                role,
                phoneNumber,
                photo,
                provinceId,
                cityId,
                districtId,
                subDistrictId,
                postcode,
                address
            )
            emit(Result.success(response))
        }.catch {
            emit(Result.failure(Throwable(handleError(it))))
        }
    }

    suspend fun login(
        email: String,
        password: String,
    ): Flow<Result<LoginResponse>> {
        return flow {
            val response = apiServiceAuth.login(
                email,
                password
            )
            userPreferences.saveUserToken(
                response.data.accessToken
            )
            userPreferences.saveUserName(response.data.user.fullName)
            userPreferences.saveUserEmail(response.data.user.email)
            emit(Result.success(response))
        }.catch {
            emit(Result.failure(Throwable(handleError(it))))
        }
    }

    suspend fun logout(): Flow<Result<Unit>> {
        return flow {
            userPreferences.clearUserToken()
            emit(Result.success(Unit))
        }.catch { throwable ->
            emit(Result.failure(Throwable(handleError(throwable))))
        }
    }

    fun getToken(): Flow<String?> {
        return userPreferences.getUserToken()
    }

    fun getUserDataEmail(): Flow<String?> {
        return userPreferences.getUserDataEmail()
    }

    fun getUserDataName(): Flow<String?> {
        return userPreferences.getUserDataName()
    }

    fun getUserId(): Flow<String?> {
        return userPreferences.getUserId()
    }


}