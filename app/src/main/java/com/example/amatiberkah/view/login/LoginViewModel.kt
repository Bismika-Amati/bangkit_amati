package com.example.amatiberkah.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amatiberkah.model.remote.response.LoginResponse
import com.example.amatiberkah.model.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {

    private val _token = MutableLiveData<String>()
    val token: LiveData<String> = _token

    suspend fun login(
        email: String,
        password: String,
    ): Flow<Result<LoginResponse>> {
        return authRepository.login(
            email,
            password,
        ).also {
            saveToken(_token.value.toString())
        }
    }

    private fun saveToken(key: String) = viewModelScope.launch {
        authRepository.saveToken(key)
    }
}
