package com.skylabstechke.todo.data.repository

import androidx.lifecycle.LiveData
import com.skylabstechke.todo.data.databaseclient.ToDoDao
import com.skylabstechke.todo.data.model.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {
    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()
    suspend fun insertData(toDoData: ToDoData) {
        toDoDao.insertData(toDoData)
    }
    suspend fun updateData(toDoData: ToDoData) {
        toDoDao.updateData(toDoData)
    }

    suspend fun deleteData(toDoData: ToDoData) {
        toDoDao.deleteData(toDoData)
    }
}