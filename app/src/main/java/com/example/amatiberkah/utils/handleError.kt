package com.example.amatiberkah.utils

import com.example.amatiberkah.model.remote.response.GeneralResponse
import com.google.gson.Gson

fun handleError(error: Throwable): String? {
    return when (error) {
        is retrofit2.HttpException -> {
            val response = error.response()
            if (response != null) {
                val errorMessage = response.errorBody()?.string()
                if (!errorMessage.isNullOrEmpty()) {
                    val errorResponse = Gson().fromJson(errorMessage, GeneralResponse::class.java)
                    errorResponse.message
                } else {
                    null
                }
            } else {
                null
            }
        }
        else -> error.message
    }
}