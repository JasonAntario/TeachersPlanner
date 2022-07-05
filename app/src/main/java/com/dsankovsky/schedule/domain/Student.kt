package com.dsankovsky.schedule.domain

data class Student(
    var id: Int = UNDEFINED_ID,
    val name: String,
    val surname: String?,
    val comment: String?,
    val payment: Float,
    val knowledgeLevel: String,
    val address: String,
    val timeTable: List<String>
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}
