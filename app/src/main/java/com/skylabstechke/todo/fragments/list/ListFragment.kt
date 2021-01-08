package com.skylabstechke.todo.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.skylabstechke.todo.R
import com.skylabstechke.todo.adapters.ListAdapter
import com.skylabstechke.todo.data.model.ToDoData
import com.skylabstechke.todo.data.viewmodel.ToDoViewModel
import com.skylabstechke.todo.data.viewmodel.common.ShareViewModel
import com.skylabstechke.todo.databinding.FragmentListBinding
import com.skylabstechke.todo.utilis.SwipeToDelete
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator


class ListFragment : Fragment() {

    private val mToDoViewModel: ToDoViewModel by viewModels()
    private val mSharedViewModel: ShareViewModel by viewModels()
    private val adapter: ListAdapter by lazy { ListAdapter() }
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.mSharedViewModel = mSharedViewModel
        //  val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView = binding.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2,Ori))
        recyclerView.itemAnimator = SlideInUpAnimator().apply {
            addDuration = 300
        }
        swipeToDelete(recyclerView)

        mToDoViewModel.getAllData.observe(viewLifecycleOwner, Observer { data ->
            mSharedViewModel.checkIfDatabaseEmpty(data)
            adapter.setData(data)

        })
//        mSharedViewModel.emptyDatabase.observe(viewLifecycleOwner, Observer { data ->
//           showEmptyDatabaseViews(data)
//        })
        setHasOptionsMenu(true)
        return binding.root
    }


    fun swipeToDelete(recyclerView: RecyclerView) {
        val swipeToDelete = object : SwipeToDelete() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val itemToDelete = adapter.datalist[viewHolder.adapterPosition]
                mToDoViewModel.delete(itemToDelete)
                adapter.notifyItemRemoved(viewHolder.adapterPosition)
//                Toast.makeText(requireContext(), "Item Deleted Successfully", Toast.LENGTH_LONG)
//                    .show()
                restoreDeleted(viewHolder.itemView, itemToDelete, viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDelete)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun restoreDeleted(view: View, toDoData: ToDoData, position: Int) {

        val snackbar = Snackbar.make(
            view,
            "Deleted Object",
            Snackbar.LENGTH_LONG

        )
        snackbar.setAction("Undo") {
            mToDoViewModel.insertData(toDoData)
            adapter.notifyItemChanged(position)
        }
        snackbar.show()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    private fun showEmptyDatabaseViews(data: Boolean) {
//
//        if (data) {
//            view?.no_data_imageView?.visibility = View.VISIBLE
//            view?.no_data_textView?.visibility = View.VISIBLE
//
//        } else {
//            view?.no_data_imageView?.visibility = View.INVISIBLE
//            view?.no_data_textView?.visibility = View.INVISIBLE
//        }
//    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.list_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_delete_all -> confirmDataRemoval()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun confirmDataRemoval() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete all Items")
        builder.setMessage("Once you delete all items they can't be retrieved")
        builder.setNegativeButton("No") { _, _ -> }
        builder.setPositiveButton("Yes") { _, _ ->
            mToDoViewModel.deleteAll()
            Toast.makeText(requireContext(), "Items Deleted Successfully", Toast.LENGTH_LONG).show()
        }
        builder.create().show()
    }
}