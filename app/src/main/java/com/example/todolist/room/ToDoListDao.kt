package com.example.todolist.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todolist.model.Task


@Dao
interface ToDoListDao {
    @Query("SELECT*FROM ToDoListDB")
    fun getTask(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun setTask(task: Task)

    @Delete
    fun deleteTask(task: Task)


}

