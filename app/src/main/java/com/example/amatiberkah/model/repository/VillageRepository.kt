package com.example.amatiberkah.model.repository

import com.example.amatiberkah.model.remote.api.ApiServiceMasterData
import com.example.amatiberkah.model.remote.response.VillageResponses
import com.example.amatiberkah.model.remote.response.VillageResponsesDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VillageRepository @Inject constructor(
    private val apiServiceMasterData: ApiServiceMasterData
){

    suspend fun getVilages(
        accessToken: String
    ): Flow<Result<VillageResponses>> {
        return flow {
            val response = apiServiceMasterData.getVilages(accessToken)
            emit(Result.success(response))
        }.catch { throwable ->
            emit(Result.failure(throwable))
        }
    }

    fun getViilagesDetail(
        id: String,
        accessToken: String
    ): Flow<Result<VillageResponsesDetail>> {
        return flow {
            val response = apiServiceMasterData.getVillageDetail(id, accessToken)
            emit(Result.success(response))
        }.catch { throwable ->
            emit(Result.failure(throwable))
        }
    }


}