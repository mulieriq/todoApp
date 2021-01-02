package com.skylabstechke.todo.data
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDoData::class],version = 1,exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDao():ToDoDao
    companion object{
        @Volatile
        private var INSTANCE :ToDoDatabase ? = null

    }
}