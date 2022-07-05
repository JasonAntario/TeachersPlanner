package com.dsankovsky.schedule.data

import java.util.stream.Collectors

class TypeConverter{

    @androidx.room.TypeConverter
    fun fromStudents(students: MutableList<String>): String? {
        return if (students.isNotEmpty())
            students.stream().collect(Collectors.joining(","))
        else
            null
    }

    @androidx.room.TypeConverter
    fun toStudents(data: String?): List<String> {
        return data?.split(",") ?: emptyList()
    }
}