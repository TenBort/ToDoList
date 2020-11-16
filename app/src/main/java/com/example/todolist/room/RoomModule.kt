package com.example.todolist.room

import android.content.Context
import com.example.todolist.repo.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Provides
    fun provideTaskDao(@ApplicationContext appContext: Context): ToDoListDao {
        return ToDoListDataBase.getTaskInstance(appContext)!!.taskDao()
    }
    @Provides
    fun provideTaskDBRepository(taskDao: ToDoListDao) =
        TaskRepository(taskDao)

}