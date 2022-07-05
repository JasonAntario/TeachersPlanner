package com.dsankovsky.schedule.domain.use_cases

import com.dsankovsky.schedule.domain.Student
import com.dsankovsky.schedule.domain.StudentsListRepository

class GetStudentUseCase(private val studentsListRepository: StudentsListRepository) {
    suspend operator fun invoke(studentId: Int): Student {
        return studentsListRepository.getStudent(studentId)
    }
}