package com.example.todolist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.model.Task


class BaseViewModel : ViewModel(){

    val list = MutableLiveData<List<Task>>()

    fun saveTask (task: Task){

        val items = mutableListOf<Task>()
        items.add(task)

        list.value = items










    }

}