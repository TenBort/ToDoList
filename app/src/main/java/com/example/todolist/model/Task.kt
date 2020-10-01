package com.example.todolist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToDoListDB")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var date: String = "",
    var name: String = "",
    var description: String = "")

