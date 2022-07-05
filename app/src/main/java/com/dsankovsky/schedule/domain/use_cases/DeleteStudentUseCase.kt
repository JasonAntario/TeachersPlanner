package com.dsankovsky.schedule.domain.use_cases

import com.dsankovsky.schedule.domain.Student
import com.dsankovsky.schedule.domain.StudentsListRepository

class DeleteStudentUseCase(private val studentsListRepository: StudentsListRepository) {
    suspend operator fun invoke(student: Student) {
        studentsListRepository.deleteStudent(student)
    }
}