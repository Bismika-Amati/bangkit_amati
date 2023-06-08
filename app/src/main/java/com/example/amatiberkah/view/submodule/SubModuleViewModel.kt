package com.example.amatiberkah.view.submodule

import androidx.lifecycle.ViewModel
import com.example.amatiberkah.model.remote.response.DetailCourseResponse
import com.example.amatiberkah.model.remote.response.SubModuleResponse
import com.example.amatiberkah.model.repository.AuthRepository
import com.example.amatiberkah.model.repository.CourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class SubModuleViewModel @Inject constructor(
    private val course : CourseRepository,
    private val auth : AuthRepository,
): ViewModel() {

    suspend fun getListSubModule(
        id: String,
        authorization: String
    ): Flow<Result<DetailCourseResponse>> {
        return course.getListSubModule(id, authorization)
    }

    fun getToken(): Flow<String?> {
        return auth.getToken()
    }
}