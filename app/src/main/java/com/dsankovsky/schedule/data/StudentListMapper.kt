package com.dsankovsky.schedule.data

import com.dsankovsky.schedule.domain.Student
import java.util.*

class StudentListMapper {

    fun mapEntityToDbModel(student: Student) = StudentDbModel(
        id = student.id,
        name = student.name,
        surname = student.surname,
        comment = student.comment,
        payment = student.payment,
        knowledgeLevel = student.knowledgeLevel,
        address = student.address,
        timeTable = student.timeTable
    )

    fun mapDbModelToEntity(studentDbModel: StudentDbModel) = Student(
        id = studentDbModel.id,
        name = studentDbModel.name,
        surname = studentDbModel.surname,
        comment = studentDbModel.comment,
        payment = studentDbModel.payment,
        knowledgeLevel = studentDbModel.knowledgeLevel,
        address = studentDbModel.address,
        timeTable = studentDbModel.timeTable ?: emptyList()
    )

    fun mapListDbModelToListEntity(list: List<StudentDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}