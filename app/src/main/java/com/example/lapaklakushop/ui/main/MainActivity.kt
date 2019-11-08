package com.example.lapaklakushop.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.lapaklakushop.R
import com.example.lapaklakushop.ui.main.adapter.PagerFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_tab.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pagerAdapter = PagerFragmentAdapter(supportFragmentManager)
        viewPagerMain.adapter = pagerAdapter

        tabLayoutMain.setupWithViewPager(viewPagerMain)

        var view = LayoutInflater.from(this).inflate(R.layout.custom_tab,null)
        view.imgCustomTab.setImageResource(R.drawable.ic_home)
        view.txtTitleTab.text = "Home"
        tabLayoutMain.getTabAt(0)?.setCustomView(view)

        var view1 = LayoutInflater.from(this).inflate(R.layout.custom_tab,null)
        view1.imgCustomTab.setImageResource(R.drawable.ic_history)
        view1.txtTitleTab.text = "History"
        tabLayoutMain.getTabAt(1)?.setCustomView(view1)

        var view2 = LayoutInflater.from(this).inflate(R.layout.custom_tab,null)
        view2.imgCustomTab.setImageResource(R.drawable.ic_account)
        view2.txtTitleTab.text = "Profile"
        tabLayoutMain.getTabAt(2)?.setCustomView(view2)

        //setIcon tablayout
        /*tabLayoutMain.getTabAt(0)?.setText("Home")?.setIcon(R.drawable.ic_home)
        tabLayoutMain.getTabAt(1)?.setText("History")?.setIcon(R.drawable.ic_history)
        tabLayoutMain.getTabAt(2)?.setText("Profile")?.setIcon(R.drawable.ic_account)*/
    }
}
