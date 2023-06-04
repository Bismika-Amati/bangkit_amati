package com.example.amatiberkah.view.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amatiberkah.model.local.UserPreferences
import com.example.amatiberkah.model.remote.api.ApiConfig
import com.example.amatiberkah.model.remote.response.LoginResponse
import com.example.amatiberkah.model.remote.response.RegisterResponse
import com.example.amatiberkah.model.remote.response.UserResponse
import com.example.amatiberkah.model.repository.AuthRepository
import com.example.amatiberkah.model.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
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
