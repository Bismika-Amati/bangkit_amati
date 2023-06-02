package com.example.amatiberkah.model.remote.response

data class UserResponse (
    val error: Boolean,
    val message: String,
    val result: LoginResult
)

data class LoginResult (
    val token: String,
    val name: String,
    val userId: String
    )