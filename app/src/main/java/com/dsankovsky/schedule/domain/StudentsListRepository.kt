package com.dsankovsky.schedule.domain

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface StudentsListRepository {
    suspend fun addStudent(student: Student)
    suspend fun deleteStudent(student: Student)
    suspend fun editStudent(student: Student)
    suspend fun getStudent(studentId: Int): Student
    fun getStudentsList(): Flow<List<Student>>
}