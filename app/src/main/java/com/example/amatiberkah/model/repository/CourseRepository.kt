package com.example.amatiberkah.model.repository

import com.example.amatiberkah.model.remote.api.ApiServiceMasterData
import com.example.amatiberkah.model.remote.response.CoursesResponses
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CourseRepository @Inject constructor(
    private val apiServiceMasterData: ApiServiceMasterData
){

    suspend fun getAllModule(
        page: Int?,
        size: Int?,
        authorization: String
    ): Flow<Result<CoursesResponses>> {
        return flow {
            val response = apiServiceMasterData.getAllCourses(page, size, authorization)
            emit(Result.success(response))
        }.catch {throwable ->
            emit(Result.failure(throwable))
        }
    }


}