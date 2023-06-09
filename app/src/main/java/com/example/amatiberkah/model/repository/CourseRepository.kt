package com.example.amatiberkah.model.repository

import com.example.amatiberkah.model.remote.api.ApiServiceMasterData
import com.example.amatiberkah.model.remote.response.CoursesResponse
import com.example.amatiberkah.model.remote.response.DetailCourseResponse
import com.example.amatiberkah.model.remote.response.DetailSubModuleResponse
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

    suspend fun getDetailModule(
        id: String,
        accessToken: String
    ): Flow<Result<DetailCourseResponse>> {
        return flow {
            val response = apiServiceMasterData.getDetailCourse(id, accessToken)
            emit(Result.success(response))
        }.catch {throwable ->
            emit(Result.failure(throwable))
        }
    }

    suspend fun getListSubModule(
        id: String,
        accessToken: String
    ): Flow<Result<DetailCourseResponse>> {
        return flow {
            val response = apiServiceMasterData.getDetailCourse(id, accessToken)
            emit(Result.success(response))
        }.catch { throwable ->
            emit(Result.failure(throwable))
        }
    }

    suspend fun getDetailSubModule(
        id: String,
        accessToken: String
    ): Flow<Result<DetailSubModuleResponse>> {
        return flow {
            val response = apiServiceMasterData.getDetailSubModule(id, accessToken)
            emit(Result.success(response))
        }.catch { throwable ->
            emit(Result.failure(throwable))
        }
    }


    suspend fun doneModule(
        userId: String,
        subModuleId: String,
        accessToken: String
    ): Flow<Result<DoneModuleResponse>> {
        return flow {
            val response = apiServiceMasterData.doneModules(
                userId,
                subModuleId,
                accessToken
            )
            emit(Result.success(response))
        }.catch {
            emit(Result.failure(Throwable(handleError(it))))
        }
    }
}