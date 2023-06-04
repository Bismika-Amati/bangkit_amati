package com.example.amatiberkah.view.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amatiberkah.model.remote.api.ApiConfig
import com.example.amatiberkah.model.remote.response.UserResponse
import com.example.amatiberkah.model.repository.UserRepository
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class LoginViewModel(
    private val userRepository: UserRepository
): ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private val _token = MutableLiveData<String>()
    val token: LiveData<String> = _token

    companion object {
        private const val TAG = "LoginViewModel"
        const val ERROR_INTERNET = "No Connection"
    }

    fun loginStudent(email: String, password: String) = viewModelScope.launch {
        _isLoading.value = true
        _isLoggedIn.value = false
        _error.value = null

        val client = ApiConfig.getApiService().loginStudent(email, password)
        client.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _token.value = response.body()?.result?.token.toString()
                    saveToken(_token.value.toString())
                    _isLoading.value = false
                    _isLoggedIn.value = true
                    Log.d(TAG, "${_isLoggedIn.value}")
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                if (t is HttpException) {
                    val errorResponse = t.response()?.errorBody()?.string()
                    val errorMessage = errorResponse?.let { JSONObject(it).getString("message") }
                    _error.value = errorMessage
                } else {
                    _error.value = ERROR_INTERNET
                }
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })

    }

    fun loginAdmin(email: String, password: String) = viewModelScope.launch {
        _isLoading.value = true
        _isLoggedIn.value = false
        _error.value = null

        val client = ApiConfig.getApiService().loginAdmin(email, password)
        client.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _token.value = response.body()?.result?.token.toString()
                    saveToken(_token.value.toString())
                    _isLoading.value = false
                    _isLoggedIn.value = true
                    Log.d(TAG, "${_isLoggedIn.value}")
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                if (t is HttpException) {
                    val errorResponse = t.response()?.errorBody()?.string()
                    val errorMessage = errorResponse?.let { JSONObject(it).getString("message") }
                    _error.value = errorMessage
                } else {
                    _error.value = ERROR_INTERNET
                }
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })

    }

    private fun saveToken(key: String) = viewModelScope.launch {
        userRepository.saveToken(key)
    }
}
