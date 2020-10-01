package com.example.todolist

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.todolist.model.Task
import com.example.todolist.repo.TaskRepository

class BaseViewModel(context: Context) : AndroidViewModel(Application()) {
    private val mRepository = TaskRepository(context)
    val allWords = MutableLiveData<List<Task>>()


    fun getTask() {
        allWords.value
        mRepository.getallTasks()
    }

    fun updateTask(task: Task) {
        mRepository.saveTask(task = task)
    }

    fun deleteTask(task: Task) {
        mRepository.deleteTask(task = task)
    }

    fun saveTask(task: Task){
        allWords.value
        mRepository.saveTask(task = task)
    }
}