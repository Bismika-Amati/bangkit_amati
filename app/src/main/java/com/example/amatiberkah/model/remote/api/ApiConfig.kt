package com.example.amatiberkah.model.remote.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {


    companion object {
        private const val apiUrl = "http://34.128.92.185:3000/api"
        private const val apiVersion = "v1.0.0"
        private const val BASEURL = "${apiUrl}/${apiVersion}"
        fun getApiServiceAuth(): ApiServiceAuth {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("${BASEURL}/auth/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiServiceAuth::class.java)
        }
    }
}