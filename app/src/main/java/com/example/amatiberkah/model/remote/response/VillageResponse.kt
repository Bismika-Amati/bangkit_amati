package com.example.amatiberkah.model.remote.response

import com.google.gson.annotations.SerializedName

data class VillageResponses(
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: List<ListVillageResponse>
)

data class ListVillageResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("provinceId")
    val provinceId: String,
    @SerializedName("cityId")
    val cityId: String,
    @SerializedName("districtId")
    val districtId: String,
    @SerializedName("subDistrictId")
    val subDistrictId: String,
    @SerializedName("postcode")
    val postcode: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("picId")
    val picId: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
)