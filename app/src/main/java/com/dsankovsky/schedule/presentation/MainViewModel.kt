package com.dsankovsky.schedule.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dsankovsky.schedule.data.StudentsListRepositoryImpl
import com.dsankovsky.schedule.domain.use_cases.AddStudentUseCase
import com.dsankovsky.schedule.domain.use_cases.GetStudentsListUseCase
import com.dsankovsky.schedule.domain.Student
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = StudentsListRepositoryImpl(application)

    private val addStudentUseCase = AddStudentUseCase(repository)
    private val getStudentsListUseCase = GetStudentsListUseCase(repository)

    val studentsList = getStudentsListUseCase()

    fun addStudent(nameSurname: String, address: String, payment: Float, knowledgeLevel: String, date: List<String>){
        viewModelScope.launch {
            addStudentUseCase.invoke(Student(
                name = nameSurname,
                payment = payment,
                totalPayment = 0f,
                surname = null,
                knowledgeLevel = knowledgeLevel,
                comment = null,
                address = address,
                timeTable = date
            ))
        }
    }

    fun checkStudentName(name: String): Boolean{
        return name.isNotBlank()
    }

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName


}