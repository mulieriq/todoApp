package com.skylabstechke.todo.adapters

import android.view.View
import android.widget.Spinner
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.skylabstechke.todo.R
import com.skylabstechke.todo.data.model.Priority
import com.skylabstechke.todo.data.model.ToDoData
import com.skylabstechke.todo.fragments.list.ListFragmentDirections

class BindingAdapters {
    companion object {
        @BindingAdapter("android:navigateToAddFragment")
        @JvmStatic
        fun navigateToAddFragment(view: FloatingActionButton, navigate: Boolean) {
            view.setOnClickListener {
                if (navigate) {
                    view.findNavController().navigate(R.id.action_listFragment_to_addFragment)
                }
            }
        }

        @BindingAdapter("android:emptyDatabase")
        @JvmStatic
        fun emptyDatabase(view: View, emptyDatabase: MutableLiveData<Boolean>) {
            when (emptyDatabase.value) {
                true -> view.visibility = View.VISIBLE
                false -> view.visibility = View.INVISIBLE
            }
        }

        @BindingAdapter("android:parsePriority")
        @JvmStatic
        fun parsePriorityToInt(view: Spinner, priority: Priority) {
            when (priority) {
                Priority.HIGH -> view.setSelection(0)
                Priority.MEDIUM -> view.setSelection(1)
                Priority.LOW -> view.setSelection(2)
            }
        }

        @BindingAdapter("android:parsePriorityText")
        @JvmStatic
        fun parsePriorityText(view: TextView, priority: Priority) {
            when (priority) {
                Priority.HIGH -> view.setText("High")
                Priority.MEDIUM -> view.setText("MEDIUM")
                Priority.LOW -> view.setText("LOW")
            }
        }

        @BindingAdapter("android:parsePriorityColor")
        @JvmStatic
        fun parsePriorityColor(cardView: CardView, priority: Priority) {
            when (priority) {
                Priority.HIGH -> cardView.setCardBackgroundColor(cardView.context.getColor(R.color.red))
                Priority.MEDIUM -> cardView.setCardBackgroundColor(cardView.context.getColor(R.color.yellow))
                Priority.LOW -> cardView.setCardBackgroundColor(cardView.context.getColor(R.color.green))
            }
        }

        @BindingAdapter("android:setTextPriorityColor")
        @JvmStatic
        fun setPriorityTextColor(view: TextView, priority: Priority) {
            when (priority) {
                Priority.HIGH -> view.setTextColor(view.context.getColor(R.color.red))
                Priority.MEDIUM -> view.setTextColor(view.context.getColor(R.color.yellow))
                Priority.LOW -> view.setTextColor(view.context.getColor(R.color.green))
            }
        }

//        @BindingAdapter("android:sendDataToUpdateFragment")
//        @JvmStatic
//
//        fun sendDataToUpdateFragment(view: ConstraintLayout, curretItem: ToDoData) {
//            view.setOnClickListener {
//                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(curretItem)
//                view.findNavController().navigate(action)
//            }
//        }

        @BindingAdapter("android:sendDataToDetailsFragment")
        @JvmStatic
        fun sendDataToDetailsFragment(view: ConstraintLayout, curretItem: ToDoData) {
            view.setOnClickListener {
                view.findNavController()
                    .navigate(ListFragmentDirections.actionListFragmentToDetailsFragment(curretItem))
            }
        }
    }
}