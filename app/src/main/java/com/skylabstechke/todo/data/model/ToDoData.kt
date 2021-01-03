package com.skylabstechke.todo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.skylabstechke.todo.data.model.Priority


@Entity(tableName = "todo_table")
data class ToDoData(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var priority: Priority,
    var description:String
)
