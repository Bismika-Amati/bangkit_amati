package com.example.amatiberkah.view.exploreVillageDetail

import androidx.lifecycle.ViewModel
import com.example.amatiberkah.model.remote.response.VillageResponsesDetail
import com.example.amatiberkah.model.repository.AuthRepository
import com.example.amatiberkah.model.repository.VillageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ExploreVillageDetailViewModel @Inject constructor(
    private val villageRepository: VillageRepository, private val authRepository: AuthRepository
) : ViewModel() {
    fun getVillagesDetail(
        id: String,
        accessToken: String
    ): Flow<Result<VillageResponsesDetail>> {
        return villageRepository.getViilagesDetail(id, accessToken)
    }

    fun getToken(): Flow<String?> {
        return authRepository.getToken()
    }
}