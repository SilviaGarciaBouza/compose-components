package com.example.mycomposeapplication.taskApp.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    //Para las acciones, el DAO
    @Provides
    fun providesTask(todoDatabase: TodoDataBase):TaskDao{
        return todoDatabase.taskDao()
    }

    //Para la Database, la lista de datos:
    @Provides
    @Singleton
    fun provideTodoDatabase(@ApplicationContext appContext: Context):TodoDataBase{
        return Room.databaseBuilder(appContext, TodoDataBase::class.java, "TaskDataBase").build()
    }
}