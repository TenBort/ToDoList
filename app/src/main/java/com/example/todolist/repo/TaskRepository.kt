package com.example.todolist.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.todolist.model.Task
import com.example.todolist.room.ToDoListDao
import com.example.todolist.room.ToDoListDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class TaskRepository(context: Context) {

    private val taskDao: ToDoListDao
    private var allTasks: LiveData<List<Task>>

    init {
        val database = ToDoListDataBase.getTaskInstanse(context)
        taskDao = database!!.taskDao()
        allTasks = taskDao.getTask()
    }
      fun saveTask(task: Task) = runBlocking{
          this.launch(Dispatchers.IO){
              taskDao.saveTask(task)
          }

      }

    fun updateTask(task: Task) = runBlocking{
        this.launch(Dispatchers.IO){
            taskDao.updateTask(task)
        }

    }
    fun deleteTask(task: Task) = runBlocking{
        this.launch(Dispatchers.IO){
            taskDao.deleteTask(task)
        }

    }


    fun getallTasks(): LiveData<List<Task>>{
        allTasks.value
        return allTasks
    }



}