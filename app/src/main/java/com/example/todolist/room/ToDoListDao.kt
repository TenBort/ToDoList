package com.example.todolist.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todolist.model.Task


@Dao
interface ToDoListDao {
    @Insert
     fun saveTask(task: Task)

    @Update
     fun updateTask(task: Task)

    @Delete
     fun deleteTask(task: Task)

    @Query("SELECT*FROM ToDoListDB")
    fun getTask():LiveData<List<Task>>




}

