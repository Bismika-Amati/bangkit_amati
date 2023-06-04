package com.example.amatiberkah.model.repository

import com.example.amatiberkah.model.remote.api.ApiServiceAuth
import com.example.amatiberkah.model.remote.response.RegisterResponse
import com.example.amatiberkah.utils.handleError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiServiceAuth: ApiServiceAuth
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

}