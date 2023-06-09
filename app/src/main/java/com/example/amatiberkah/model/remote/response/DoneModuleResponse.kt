package com.example.amatiberkah.model.remote.response

import com.google.gson.annotations.SerializedName

data class DoneModuleResponse (
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: dataDoneModule
)

data class dataDoneModule(
    @SerializedName("id")
    val id: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("subModuleId")
    val subModuleId: String,
)