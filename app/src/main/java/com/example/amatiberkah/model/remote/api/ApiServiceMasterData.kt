package com.example.amatiberkah.model.remote.api

import com.example.amatiberkah.model.remote.response.CoursesResponse
import com.example.amatiberkah.model.remote.response.VillageResponses
import com.example.amatiberkah.model.remote.response.VillageResponsesDetail
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
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

    @GET("villages/{id}")
    suspend fun getVillageDetail(
        @Path("id") id: String,
        @Header("accessToken") accessToken: String
    ) : VillageResponsesDetail

}