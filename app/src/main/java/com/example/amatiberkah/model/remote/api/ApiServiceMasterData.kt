package com.example.amatiberkah.model.remote.api

import com.example.amatiberkah.model.remote.response.CoursesResponses
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiServiceMasterData {

    @GET("courses")
    suspend fun getAllCourses(
        @Header("accessToken") accessToken: String
    ) : CoursesResponses


}