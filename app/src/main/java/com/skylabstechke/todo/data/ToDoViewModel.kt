package com.skylabstechke.todo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.skylabstechke.todo.data.databaseclient.ToDoDatabase
import com.skylabstechke.todo.data.model.ToDoData
import com.skylabstechke.todo.data.repository.ToDoRepository

class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
    private val repository: ToDoRepository
    private lateinit var getAllData: LiveData<List<ToDoData>>

    init {
        repository = ToDoRepository(toDoDao)
        getAllData = repository.getAllData
    }
}