package com.skylabstechke.todo.data

import androidx.room.Database

@Database(entities = [ToDoData::class],version = 1,exportSchema = false)
abstract class ToDoDatabase {
}