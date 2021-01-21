package com.skylabstechke.todo.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.skylabstechke.todo.data.model.Priority
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "todo_table")
@Parcelize
data class ToDoData(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var priority: Priority,
    var description:String,
   // var deadline:String
) : Parcelable
