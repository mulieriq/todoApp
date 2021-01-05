package com.skylabstechke.todo.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.skylabstechke.todo.R
import com.skylabstechke.todo.data.viewmodel.ToDoViewModel
import com.skylabstechke.todo.data.viewmodel.common.ShareViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private val mToDoViewModel: ToDoViewModel by viewModels()
    private val mSharedViewModel: ShareViewModel by viewModels()
    private val adapter: ListAdapter by lazy { ListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        mToDoViewModel.getAllData.observe(viewLifecycleOwner, Observer { data ->
            mSharedViewModel.checkIfDatabaseEmpty(data)
            adapter.setData(data)

        })
        mSharedViewModel.emptyDatabase.observe(viewLifecycleOwner, Observer {data->
            showEmptyDatabaseViews(data)
        })
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        setHasOptionsMenu(true)
        return view
    }

    private fun showEmptyDatabaseViews(data:Boolean) {



    }

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