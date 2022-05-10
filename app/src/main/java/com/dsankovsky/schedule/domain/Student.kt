package com.dsankovsky.tutorsschedule.domain

import java.util.*

data class Student(
    val name: String,
    val surname: String?,
    val comment: String?,
    val payment: Float,
    val knowledgeLevel: String,
    val address: String,
    val timeTable: Date
)
