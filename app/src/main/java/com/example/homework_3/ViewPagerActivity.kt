package com.example.homework_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_view_pager.*


class ViewPagerActivity : AppCompatActivity() {
//    private lateinit var vp: androidx.viewpager.widget.ViewPager
//    private lateinit var tablayout:TabLayout
//    var tabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
//        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        tabLayout!!.addTab(tabLayout!!.newTab().setText("movieList[i].title"))
//        tabLayout=findViewById<TabLayout>(R.id.tabLayout)
        viewPager.adapter = SimplePagerAdapter(supportFragmentManager,tabLayout)

//        tabLayout!!.addTab(tabLayout!!.newTab().setText("movieList[i].title"))
//        vp = findViewById(R.id.viewPager)
        tabLayout.setupWithViewPager(viewPager)

//        tabLayout!!.addTab(tabLayout!!.newTab().setText("movieList[i].title"))
//

        viewPager.currentItem = 0




        viewPager.setPageTransformer(false) { p0, p1 ->
            val norm = Math.abs(Math.abs(p1) - 1)
            p0.scaleX = norm/2 + 0.5f
            p0.scaleY = norm/2 + 0.5f
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}