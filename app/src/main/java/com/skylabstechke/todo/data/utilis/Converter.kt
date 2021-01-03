package com.skylabstechke.todo.data.utilis

import androidx.room.TypeConverter
import com.skylabstechke.todo.data.model.Priority

class Converter {

    @TypeConverter
    fun  fromPriority(priority: Priority):String{
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }
}