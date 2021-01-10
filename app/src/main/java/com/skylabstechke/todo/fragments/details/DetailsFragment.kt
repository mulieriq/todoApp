package com.skylabstechke.todo.fragments.details

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.skylabstechke.todo.R
import com.skylabstechke.todo.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private val args by navArgs<DetailsFragmentArgs>()
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.args = args
        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.update_item) {
            findNavController().navigate(
                DetailsFragmentDirections.actionDetailsFragmentToUpdateFragment2(
                    args.current
                )
            )

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