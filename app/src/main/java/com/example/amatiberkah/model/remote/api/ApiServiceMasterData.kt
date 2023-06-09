package com.example.amatiberkah.model.remote.api

import com.example.amatiberkah.model.remote.response.*
import com.example.amatiberkah.model.remote.response.VillageResponsesDetail
import retrofit2.http.*

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

    @GET("courses/{id}")
    suspend fun getDetailCourse(
        @Path("id") id: String,
        @Header("accessToken") accessToken: String
    ) : DetailCourseResponse

//    @GET
//    suspend fun getListSubModule(
//        @Header("accessToken") accessToken: String
//    ) :

    @GET("sub-modules/{id}")
    suspend fun getDetailSubModule(
        @Path("id") id: String,
        @Header("accessToken") accessToken: String
    ) : DetailSubModuleResponse

    @POST("done-modules")
    @FormUrlEncoded
    suspend fun doneModules (
        @Field("userId") userId: String,
        @Field("subModuleId") subModuleId: String,
        @Header("accessToken") accessToken: String
    ) : DoneModuleResponse
}