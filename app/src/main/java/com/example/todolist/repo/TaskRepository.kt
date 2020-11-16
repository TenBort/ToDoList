package com.example.todolist.repo


import com.example.todolist.model.Task
import com.example.todolist.room.ToDoListDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
class TaskRepository @Inject constructor(private val toDoListDao : ToDoListDao):
CoroutineScope {

    private val tasks = toDoListDao.getTask()

    fun getTaskList() = tasks

    suspend fun setTasks (task: Task){
        toDoListDao.setTask(task)
    }
    fun deleteTask(task: Task){
        toDoListDao.deleteTask(task)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

}