package com.skylabstechke.todo.fragments.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.skylabstechke.todo.R
import com.skylabstechke.todo.adapters.ViewPagerAdapter
import com.skylabstechke.todo.fragments.onboarding.screens.SplashScreen1
import com.skylabstechke.todo.fragments.onboarding.screens.SplashScreen2
import com.skylabstechke.todo.fragments.onboarding.screens.SplashScreen3
import kotlinx.android.synthetic.main.fragment_view_pager.*
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            SplashScreen1(),
            SplashScreen2(),
            SplashScreen3()
        )

        val adapter  = ViewPagerAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)
         view.viewPager.adapter = adapter
        return  view
    }


}