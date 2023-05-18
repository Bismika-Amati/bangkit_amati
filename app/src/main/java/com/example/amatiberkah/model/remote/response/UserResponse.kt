package com.example.amatiberkah.model.remote.response

data class UserResponse (
    val error: Boolean,
    val message: String,
    val resul: List<LoginResult>
)

data class LoginResult (
    val token: String,
    val name: String,
    val userId: String
    )