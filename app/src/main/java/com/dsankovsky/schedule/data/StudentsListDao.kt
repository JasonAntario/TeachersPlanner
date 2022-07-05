package com.dsankovsky.schedule.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentsListDao {

    @Query("SELECT * FROM students")
    fun getStudentsList(): Flow<List<StudentDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudent(studentDbModel: StudentDbModel)

    @Query("DELETE FROM students WHERE id=:studentId")
    suspend fun deleteStudent(studentId: Int)

    @Query("SELECT * FROM students WHERE id=:studentId LIMIT 1")
    suspend fun getStudent(studentId: Int): StudentDbModel
}