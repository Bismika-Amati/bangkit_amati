package com.example.amatiberkah.model.remote.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: RegisterDataResponse
)

data class RegisterDataResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("roleId")
    val roleId: String,
    @SerializedName("provinceId")
    val provinceId: String?,
    @SerializedName("cityId")
    val cityId: String?,
    @SerializedName("districtId")
    val districtId: String?,
    @SerializedName("subDistrictId")
    val subDistrictId: String?,
    @SerializedName("postcode")
    val postcode: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("deletedAt")
    val deletedAt: String?,
)

data class LoginResponse(
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: LoginResponseData
)

data class LoginResponseData(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("user")
    val user: LoginResponseDataUser
)

data class LoginResponseDataUser(
    @SerializedName("id")
    val id: String,
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("roleId")
    val roleId: String,
    @SerializedName("provinceId")
    val provinceId: String?,
    @SerializedName("cityId")
    val cityId: String?,
    @SerializedName("districtId")
    val districtId: String?,
    @SerializedName("subDistrictId")
    val subDistrictId: String?,
    @SerializedName("postcode")
    val postcode: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("deletedAt")
    val deletedAt: String?,
    @SerializedName("role")
    val role: LoginResponseDataUserRole
)

data class LoginResponseDataUserRole(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("deletedAt")
    val deletedAt: String?,
)