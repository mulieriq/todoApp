package com.skylabstechke.todo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.skylabstechke.todo.data.databaseclient.ToDoDatabase
import com.skylabstechke.todo.data.repository.ToDoRepository

class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    private val toDoDao= ToDoDatabase.getDatabase(application).toDoDao()
    private val repository:ToDoRepository

    init {
        repository = ToDoRepository(toDoDao)
    }
}