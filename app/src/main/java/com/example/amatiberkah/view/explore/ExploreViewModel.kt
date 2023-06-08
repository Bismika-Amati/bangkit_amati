package com.example.amatiberkah.view.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.amatiberkah.model.remote.response.CoursesResponse
import com.example.amatiberkah.model.remote.response.LoginResponseDataUser
import com.example.amatiberkah.model.remote.response.VillageResponses
import com.example.amatiberkah.model.repository.AuthRepository
import com.example.amatiberkah.model.repository.CourseRepository
import com.example.amatiberkah.model.repository.VillageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val course : CourseRepository,
    private val auth : AuthRepository,
    private val village : VillageRepository
): ViewModel() {




    suspend fun getAllModule(
        accessToken: String
    ): Flow<Result<CoursesResponse>> {
        return course.getAllModule(accessToken)
    }

    suspend fun getVillages(
        accessToken: String
    ): Flow<Result<VillageResponses>> {
        return village.getVilages(accessToken)
    }

    fun getToken(): Flow<String?> {
        return auth.getToken()
    }

    fun getUserDataName(): Flow<String?> {
        return auth.getUserDataName()
    }

    fun getUserDataEmail(): Flow<String?> {
        return auth.getUserDataEmail()
    }
}