package com.dsankovsky.schedule.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val surname: String?,
    val comment: String?,
    val payment: Float,
    val knowledgeLevel: String,
    val address: String,
    val timeTable: List<String>?
)