package com.dsankovsky.schedule.presentation

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
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

class AddStudentDialog: DialogFragment() {

    private var _binding: DialogAddStudentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    private val dateTimeList = mutableListOf<String>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogAddStudentBinding.inflate(LayoutInflater.from(context))
        viewModel = ViewModelProvider(activity as MainActivity)[MainViewModel::class.java]

        val dialogBuilder = MaterialAlertDialogBuilder(requireContext())
            .setView(binding.root)
            .setNegativeButton("Cancel"){ dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Create"){dialog, which ->
                viewModel.addStudent(binding.addStudentNameValue.text.toString(),
                    binding.addStudentAddressValue.text.toString(),
                    binding.addStudentPaymentValue.text.toString().toFloat(),
                    binding.addStudentKnowledgeLevelValue.text.toString(),
                    dateTimeList
                )
            }

        binding.addStudentAddLessonButton.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select day of the week")
                .setPositiveButtonText("Ok")
                .setNegativeButtonText("Cancel")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()

            val timePicker = MaterialTimePicker.Builder()
                .setTitleText("Select time")
                .setPositiveButtonText("Ok")
                .setNegativeButtonText("Cancel")
                .build()

            timePicker.addOnPositiveButtonClickListener {
                Log.i(TAG, "onCreateDialog: ${timePicker.hour}:${timePicker.minute}")
                time = "${timePicker.hour}:${timePicker.minute}"
                val dayTime = "$dayOfWeek $time"
                dateTimeList.add(dayTime)
                val chip = Chip(requireContext()).apply {
                    text = dayTime
                }
                binding.chipGroup.addView(chip)
            }

            datePicker.addOnPositiveButtonClickListener {
                val formatter: DateFormat = SimpleDateFormat("E", Locale.US)
                val day = formatter.format(Date(it))
                dayOfWeek = day
                timePicker.show(requireActivity().supportFragmentManager, null)
            }
            datePicker.show(requireActivity().supportFragmentManager, null)
        }

        return dialogBuilder.create()
    }

    private var dayOfWeek = ""
    private var time = ""


    companion object {
        private const val TAG = "AddStudentsDialog"
    }
}