package com.skylabstechke.todo.data

import androidx.room.TypeConverter

class Converter {

    @TypeConverter
    fun  fromPriority(priority: Priority):String{
        return priority.name
    }


}