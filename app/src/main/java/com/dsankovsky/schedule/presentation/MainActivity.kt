package com.dsankovsky.schedule.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import com.dsankovsky.schedule.R
import com.dsankovsky.schedule.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val adapter = StudentsListAdapter()
        binding.recyclerView.adapter = adapter

        lifecycle.coroutineScope.launch {
            viewModel.studentsList.collect(){
                adapter.submitList(it)
            }
        }

        binding.navRail.selectedItemId = R.id.students
        setupClickListeners()
    }

    private fun setupClickListeners(){
        with(binding){
            addStudentButton.setOnClickListener {
                showAddStudentDialog()
            }
        }
    }

    private fun showAddStudentDialog() {
        AddStudentDialog().show(supportFragmentManager, null)
    }

    companion object{
        private const val TAG = "MainActivity"
    }
}