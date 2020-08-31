package com.example.todolist

import androidx.lifecycle.ViewModel
import com.example.todolist.model.Task


class BaseViewModel : ViewModel(){

    val list = mutableListOf<Task>()

    fun saveTask (task: Task){

        list.add(task)

    }

}