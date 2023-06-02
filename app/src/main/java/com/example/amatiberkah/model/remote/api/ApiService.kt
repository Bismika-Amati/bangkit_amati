package com.example.amatiberkah.model.remote.api

import com.example.amatiberkah.model.remote.response.GeneralResponse
import com.example.amatiberkah.model.remote.response.UserResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("register")
    @FormUrlEncoded
    fun register (
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("password") password: String,
        @Field("role") role: String,
    ) : Call<GeneralResponse>

    @POST("auth/login-by-role?role=admin")
    @FormUrlEncoded
    fun loginAdmin (
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<UserResponse>

    @POST("auth/login-by-role?role=student")
    @FormUrlEncoded
    fun loginStudent (
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<UserResponse>


}