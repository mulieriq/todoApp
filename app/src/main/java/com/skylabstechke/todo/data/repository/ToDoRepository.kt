package com.skylabstechke.todo.data.repository

import androidx.lifecycle.LiveData
import com.skylabstechke.todo.data.ToDoDao
import com.skylabstechke.todo.data.model.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {
    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()
    suspend fun insertData(toDoData: ToDoData) {
        toDoDao.insertData(toDoData)
    }
}