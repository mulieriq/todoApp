package com.skylabstechke.todo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skylabstechke.todo.data.model.ToDoData
import com.skylabstechke.todo.databinding.RowLayoutBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

     var datalist = emptyList<ToDoData>()

    class MyViewHolder(private val binding: RowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(toDoData: ToDoData) {
            binding.toDoData = toDoData
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
//        return MyViewHolder(view)
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])

//        holder.itemView.title_txt.text = datalist[position].title
//        holder.itemView.description_txt.text = datalist[position].description
//        holder.itemView.row_background.setOnClickListener {
//            val action =
//                ListFragmentDirections.actionListFragmentToUpdateFragment(datalist[position])
//            holder.itemView.findNavController().navigate(action)
//        }
//        val priority = datalist[position].priority
//        when (priority) {
//
//            Priority.HIGH -> holder.itemView.priority_indicator.setCardBackgroundColor(
//                ContextCompat.getColor(
//                    holder.itemView.context,
//                    R.color.red
//                )
//            )
//            Priority.MEDIUM -> holder.itemView.priority_indicator.setCardBackgroundColor(
//                ContextCompat.getColor(
//                    holder.itemView.context,
//                    R.color.yellow
//                )
//            )
//            Priority.LOW -> holder.itemView.priority_indicator.setCardBackgroundColor(
//                ContextCompat.getColor(
//                    holder.itemView.context,
//                    R.color.green
//                )
//            )
//        }
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun setData(toDoData: List<ToDoData>) {
        datalist = toDoData
        notifyDataSetChanged()
    }

}