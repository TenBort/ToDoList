package com.example.todolist.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room

import androidx.room.RoomDatabase
import com.example.todolist.model.Task


@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class ToDoListDataBase : RoomDatabase() {

    abstract fun taskDao(): ToDoListDao

    companion object {
        var INSTANCE: ToDoListDataBase? = null

        fun getTaskInstance(context: Context): ToDoListDataBase? {
            if (INSTANCE == null) {
                synchronized(ToDoListDataBase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        ToDoListDataBase::class.java,
                        "Todo-database"
                    )
                        .allowMainThreadQueries()
                        .build()

                }
            }
            return INSTANCE
        }
    }
}