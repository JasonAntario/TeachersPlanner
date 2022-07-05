package com.dsankovsky.schedule.domain.use_cases

import com.dsankovsky.schedule.domain.Student
import com.dsankovsky.schedule.domain.StudentsListRepository
import kotlinx.coroutines.flow.Flow

class GetStudentsListUseCase(private val studentsListRepository: StudentsListRepository) {
    operator fun invoke(): Flow<List<Student>> {
        return studentsListRepository.getStudentsList()
    }
}