package com.example.amatiberkah.model.remote.response

import com.google.gson.annotations.SerializedName

data class DetailSubModuleResponse(

    @field:SerializedName("data")
	val data: SubModuleData,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class ArticleSubModuleItem(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("subModuleId")
	val subModuleId: String? = null,

	@field:SerializedName("deletedAt")
	val deletedAt: Any? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("video")
	val video: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("picture")
	val picture: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)

data class SubModuleData(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("deletedAt")
	val deletedAt: Any? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("course")
	val course: Course? = null,

	@field:SerializedName("articleSubModule")
	val articleSubModule: List<ArticleSubModuleItem>,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("video")
	val video: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("courseId")
	val courseId: String? = null,

	@field:SerializedName("picture")
	val picture: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)

data class Course(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("amount")
	val amount: Int? = null,

	@field:SerializedName("deletedAt")
	val deletedAt: Any? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("estimateCompleated")
	val estimateCompleated: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
