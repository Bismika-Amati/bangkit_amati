package com.example.amatiberkah.model.remote.api

import com.example.amatiberkah.model.remote.response.CoursesResponse
import com.example.amatiberkah.model.remote.response.VillageResponses
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiServiceMasterData {

    @GET("courses")
    suspend fun getAllCourses(
        @Header("accessToken") accessToken: String
    ) : CoursesResponse

    @GET("villages")
    suspend fun getVilages(
        @Header("accessToken") accessToken: String
    ) : VillageResponses

}