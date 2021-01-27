package com.skylabstechke.todo.fragments.onboarding

import android.app.ActionBar
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.skylabstechke.todo.R


class SplashScreen : Fragment() {

     override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         Handler().postDelayed({
             findNavController().navigate(R.id.action_splashScreen_to_viewPagerFragment)
         },3000)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }


}