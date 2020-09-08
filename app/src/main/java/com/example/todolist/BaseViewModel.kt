package com.example.todolist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.adapters.ToDoRecyclerAdapter
import com.example.todolist.model.Task


class BaseViewModel : ViewModel(){
//    val adaterRecycler = ToDoRecyclerAdapter()
//
//    val list = MutableLiveData<List<Task>>()
//
//    fun saveTask (task: Task){
//        //adaterRecycler.list = list.value!!
//        val items = mutableListOf<Task>()
//        items.add(task)
//
//        list.value = items
//    }

    val list = MutableLiveData<MutableList<Task>>(mutableListOf())

    fun saveTask(task: Task) = list.value!!.add(task)

}