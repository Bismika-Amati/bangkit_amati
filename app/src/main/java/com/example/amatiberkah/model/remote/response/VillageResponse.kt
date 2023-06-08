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

data class VillageResponsesDetail(
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: ListVillageResponseDetail
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
    @SerializedName("city")
    val city: VillageCityResponse,
    @SerializedName("villagePicture")
    val villagePicture: List<VillagePictureResponse>,
)

data class ListVillageResponseDetail(
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
    @SerializedName("city")
    val city: VillageCityResponse,
    @SerializedName("villagePicture")
    val villagePicture: List<VillagePictureResponse>,
    @SerializedName("problemStatement")
    val problemStatement: List<VillageProblemResponse>

)

data class VillageCityResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
)

data class VillagePictureResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("photo")
    val photo: String,
)

data class VillageProblemResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("topic")
    val topic: String,
    @SerializedName("description")
    val description: String,
)
