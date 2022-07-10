package com.dsankovsky.schedule.presentation

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.dsankovsky.schedule.R
import com.dsankovsky.schedule.databinding.DialogAddStudentBinding
import com.google.android.material.chip.Chip
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.timepicker.MaterialTimePicker
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class AddStudentDialog : DialogFragment() {

    private var _binding: DialogAddStudentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    private val dateTimeList = mutableListOf<String>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogAddStudentBinding.inflate(LayoutInflater.from(context))
        viewModel = ViewModelProvider(activity as MainActivity)[MainViewModel::class.java]

        val dialogBuilder = MaterialAlertDialogBuilder(requireContext())
            .setView(binding.root)
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Create", null)

        val listOfDays = arrayOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")
        val listOfHours = mutableListOf<String>()
        val listOfMinutes = mutableListOf<String>()
        for (i in 8..23) {
            if (i < 10) {
                listOfHours.add("0$i")
            } else {
                listOfHours.add(i.toString())
            }
        }
        for (i in 0..55 step 5) {
            if (i < 10) {
                listOfMinutes.add("0$i")
            } else {
                listOfMinutes.add(i.toString())
            }

        }
        binding.dayOfWeekPicker.apply {
            minValue = 0
            maxValue = listOfDays.size - 1
            displayedValues = listOfDays
            wrapSelectorWheel = false
        }
        binding.hourPicker.apply {
            minValue = 0
            maxValue = listOfHours.size - 1
            displayedValues = listOfHours.toTypedArray()
            value = 4
            wrapSelectorWheel = false
        }
        binding.minutesPicker.apply {
            minValue = 0
            maxValue = listOfMinutes.size - 1
            displayedValues = listOfMinutes.toTypedArray()
            wrapSelectorWheel = false
        }

        binding.addStudentAddLessonButton.setOnClickListener {
            val day = listOfDays[binding.dayOfWeekPicker.value]
            val hour = listOfHours[binding.hourPicker.value]
            val minutes = listOfMinutes[binding.minutesPicker.value]
            val dayTime = "$day, $hour:$minutes"
            dateTimeList.add(dayTime)
            val chip = Chip(requireContext()).apply {
                text = dayTime
            }
            binding.chipGroup.addView(chip)
        }

        return dialogBuilder.create()
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog as AlertDialog
        dialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener {
            val payment = binding.addStudentPaymentValue.text.toString().toFloatOrNull()
            if (viewModel.checkStudentName(binding.addStudentNameValue.text.toString())) {
                viewModel.addStudent(
                    binding.addStudentNameValue.text.toString(),
                    binding.addStudentAddressValue.text.toString(),
                    payment ?: 0f,
                    binding.addStudentKnowledgeLevelValue.text.toString(),
                    dateTimeList
                )
                dialog.dismiss()
            } else {
                binding.addStudentName.error = "Enter name of the student"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val TAG = "AddStudentsDialog"
    }
}