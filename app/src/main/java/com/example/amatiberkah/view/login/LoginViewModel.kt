package com.example.amatiberkah.view.login

import androidx.lifecycle.ViewModel
import com.example.amatiberkah.model.remote.response.LoginResponse
import com.example.amatiberkah.model.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {

    suspend fun login(
        email: String,
        password: String,
    ): Flow<Result<LoginResponse>> {
        return authRepository.login(
            email,
            password,
        )
    }
}
