package com.skylabstechke.todo.fragments.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.skylabstechke.todo.R
import kotlinx.android.synthetic.main.fragment_splash_screen3.*
import kotlinx.android.synthetic.main.fragment_splash_screen3.view.*


class SplashScreen3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash_screen3, container, false)
          view.buttonlast.setOnClickListener {
               findNavController().navigate(R.id.action_viewPagerFragment_to_listFragment)
           }
        return view
    }

}