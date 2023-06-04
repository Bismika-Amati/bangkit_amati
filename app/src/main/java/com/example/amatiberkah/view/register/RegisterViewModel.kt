package com.example.amatiberkah.view.register

import androidx.lifecycle.ViewModel
import com.example.amatiberkah.model.remote.response.RegisterResponse
import com.example.amatiberkah.model.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel()
{
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
        return authRepository.registerByRole(
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
    }
}