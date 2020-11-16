package com.example.todolist


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.model.Task
import com.example.todolist.repo.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BaseViewModel @ViewModelInject constructor(private val repository: TaskRepository) :
    ViewModel() {

    val taskListLiveData: LiveData<List<Task>> = repository.getTaskList()
    val oneTaskLiveData = MutableLiveData<Task>()

    fun getTask() = taskListLiveData

    fun deleteTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTask(task)
        }
    }

    fun detailView(task: Task) {
        oneTaskLiveData.value = task
    }

    fun setTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setTasks(task)
        }
    }
}