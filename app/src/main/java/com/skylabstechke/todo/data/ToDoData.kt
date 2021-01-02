package com.skylabstechke.todo.data

import androidx.room.Entity


@Entity(tableName = "todo_table")
data class ToDoData(
    var id:Int,
    var title:String,
    var priority: Priority,
    var description:String
)
