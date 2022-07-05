package com.dsankovsky.schedule.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.dsankovsky.schedule.databinding.ItemStudentBinding
import com.dsankovsky.schedule.domain.Student
import com.google.android.material.chip.Chip

class StudentsListAdapter :
    ListAdapter<Student, StudentsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        return StudentsViewHolder(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        val item = getItem(position)
        holder.studentAddressTv.text = item.address
        holder.studentNameTv.text = item.name
        item.timeTable.let { list ->
            if (list.isNotEmpty()) {
                list.forEach { itemDate ->
                    holder.studentDateCg.apply {
                        this.addView(Chip(context).apply {
                            text = itemDate
                        })
                    }
                }
            }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(oldItem: Student, newItem: Student) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Student, newItem: Student) =
            oldItem.id == newItem.id

    }
}