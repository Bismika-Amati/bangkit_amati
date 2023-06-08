package com.example.amatiberkah.view.detail

import androidx.lifecycle.ViewModel
import com.example.amatiberkah.model.remote.response.DataItem
import com.example.amatiberkah.model.remote.response.DetailCourseResponse
import com.example.amatiberkah.model.repository.AuthRepository
import com.example.amatiberkah.model.repository.CourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DetailCourseViewModel @Inject constructor(
    private val auth : AuthRepository,
    private val course : CourseRepository
): ViewModel() {

    suspend fun getCourseDetail(
        id: String,
        authorization: String
    ): Flow<Result<DetailCourseResponse>> {
        return course.getDetailModule(id, authorization)
    }

    fun getToken(): Flow<String?> {
        return auth.getToken()
    }
}