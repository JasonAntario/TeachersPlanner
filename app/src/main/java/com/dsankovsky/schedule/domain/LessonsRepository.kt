package com.dsankovsky.schedule.domain

import androidx.lifecycle.LiveData

interface LessonsRepository {
    suspend fun addLesson(lesson: Lesson)
    suspend fun deleteLesson(lesson: Lesson)
    suspend fun editLesson(lesson: Lesson)
    suspend fun getLesson(lessonId: Int): Lesson
    fun getShopList(): LiveData<List<Lesson>>
}