package com.example.todolist.room

import android.content.Context
import androidx.room.Database

import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.todolist.model.Task


@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class ToDoListDataBase : RoomDatabase() {

    abstract fun taskDao(): ToDoListDao

    companion object {
        var INSTANCE: ToDoListDataBase? = null

        fun getTaskInstanse(context: Context): ToDoListDataBase? {
            if (INSTANCE == null) {
                synchronized(ToDoListDataBase::class.java) {
                    INSTANCE = databaseBuilder(
                        context,
                        ToDoListDataBase::class.java,
                        "Todo-database"
                    ).allowMainThreadQueries().build()

                }
            }
            return INSTANCE
        }
    }
}