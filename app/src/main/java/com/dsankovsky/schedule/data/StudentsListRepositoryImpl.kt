package com.dsankovsky.schedule.data

import android.app.Application
import androidx.lifecycle.Transformations
import com.dsankovsky.schedule.domain.Student
import com.dsankovsky.schedule.domain.StudentsListRepository
import kotlinx.coroutines.flow.*

class StudentsListRepositoryImpl(application: Application) : StudentsListRepository {

    private val studentsListDao = AppDatabase.getInstance(application).studentsListDao()
    private val mapper = StudentListMapper()

    override suspend fun addStudent(student: Student) {
        studentsListDao.addStudent(mapper.mapEntityToDbModel(student))
    }

    override suspend fun deleteStudent(student: Student) {
        TODO("Not yet implemented")
    }

    override suspend fun editStudent(student: Student) {
        TODO("Not yet implemented")
    }

    override suspend fun getStudent(studentId: Int): Student {
        TODO("Not yet implemented")
    }

    override fun getStudentsList(): Flow<List<Student>> =
        studentsListDao.getStudentsList()
            .map {
                mapper.mapListDbModelToListEntity(it)
            }
}