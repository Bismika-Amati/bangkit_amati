package com.example.amatiberkah.model.repository

import com.example.amatiberkah.model.remote.api.ApiServiceMasterData
import com.example.amatiberkah.model.remote.response.CoursesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CourseRepository @Inject constructor(
    private val apiServiceMasterData: ApiServiceMasterData
){

    suspend fun getAllModule(
        accessToken: String
    ): Flow<Result<CoursesResponse>> {
        return flow {
            val response = apiServiceMasterData.getAllCourses(accessToken)
            emit(Result.success(response))
        }.catch {throwable ->
            emit(Result.failure(throwable))
        }
    }


}