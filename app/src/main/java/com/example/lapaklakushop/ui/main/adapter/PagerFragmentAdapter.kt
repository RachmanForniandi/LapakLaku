package com.example.lapaklakushop.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.lapaklakushop.ui.main.history.HistoryFragment
import com.example.lapaklakushop.ui.main.home.HomeFragment
import com.example.lapaklakushop.ui.main.profile.ProfileFragment

class PagerFragmentAdapter(fm: FragmentManager):FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {

        var fragment = Fragment()
        when(position){
            /*0 -> return HomeFragment()
            1 -> return HistoryFragment()
            2 -> return ProfileFragment()*/
            0 -> fragment = HomeFragment()
            1 -> fragment = HistoryFragment()
            2 -> fragment = ProfileFragment()

        }
        return fragment
    }

    override fun getCount()=3

    override fun getPageTitle(position: Int): CharSequence? {

       var name =""
        when(position){
            0 -> name = "Home"
            1 -> name = "History"
            2 -> name = "Profile"

        }
        return name

    }
}