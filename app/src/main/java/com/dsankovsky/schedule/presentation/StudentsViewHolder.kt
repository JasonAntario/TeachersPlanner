package com.dsankovsky.schedule.presentation

import androidx.recyclerview.widget.RecyclerView
import com.dsankovsky.schedule.databinding.ItemStudentBinding

class StudentsViewHolder(binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root) {

    val studentNameTv = binding.studentNameTV
    val studentAddressTv = binding.studentAddressTv
    val studentDateCg = binding.studentDatesCG
    val itemView = binding.root
}