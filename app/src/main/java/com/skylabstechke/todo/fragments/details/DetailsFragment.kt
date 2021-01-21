package com.skylabstechke.todo.fragments.details

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.skylabstechke.todo.R
import com.skylabstechke.todo.data.viewmodel.ToDoViewModel
import com.skylabstechke.todo.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private val args by navArgs<DetailsFragmentArgs>()
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val mToDoViewModel: ToDoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.args = args
        setHasOptionsMenu(true)
        return binding.root

    }

    private fun confirmItemRemoval() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mToDoViewModel.delete(args.current)
            Toast.makeText(requireContext(), "Item Deleted", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_detailsFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.current.title}")
        builder.setMessage("Are you sure you want to delete ${args.current.title}")
        builder.create().show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        if (item.itemId == R.id.update_item) {
            findNavController().navigate(
                DetailsFragmentDirections.actionDetailsFragmentToUpdateFragment2(
                    args.current
                )
            )

        } else if (item.itemId == R.id.update_delete) {
            confirmItemRemoval()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.details_fragment, menu)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}