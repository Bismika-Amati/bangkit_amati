package com.example.amatiberkah.model.remote.response

data class CoursesResponses(
    val error: Int,
    val message: String,
    val listCourse: List<ListCourseResponse>
)

data class ListCourseResponse(
    val id: String,
    val title: String,
    val description: String,
    val photoUrl: String,
    val amount: String,
    val estimatedTime: Int,
    val subModule: SubModuleResponse
)

data class SubModuleResponse(
    val id: String,
    val number: Int,
    val title: String,
    val description: String,
    val photoUrl: String
)