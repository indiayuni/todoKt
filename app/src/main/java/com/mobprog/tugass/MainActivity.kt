package com.mobprog.tugass

import Task
import TaskAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter
    private val taskList = mutableListOf<Task>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTask = findViewById<EditText>(R.id.inputTask)
        val btnAddTask = findViewById<Button>(R.id.btnAddTask)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        taskAdapter = TaskAdapter(taskList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter


        btnAddTask.setOnClickListener {
            val taskName = inputTask.text.toString().trim()
            if (taskName.isNotEmpty()) {
                taskList.add(Task(taskName))
                taskAdapter.notifyDataSetChanged()
                inputTask.text.clear()
            }
        }
    }
}
