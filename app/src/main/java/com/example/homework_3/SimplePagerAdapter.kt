package com.example.homework_3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson


class SimplePagerAdapter(fragmentManager: FragmentManager, tabLayout: TabLayout?) :
        androidx.fragment.app.FragmentPagerAdapter(fragmentManager) {
    var movieList: List<MovieData> = Gson().fromJson(movies, Array<MovieData>::class.java).asList()

    var posterTable:MutableMap<String, Int> = mutableMapOf()
    var movieIndex=0
    init{
        posterTable[movieList[0].title]=R.drawable.pci1aryw7oj2eyto2nmyekhhicp
        posterTable[movieList[1].title]=R.drawable.oyg9tl7fcrp4ez9vid6ukzwdndz
        posterTable[movieList[2].title]=R.drawable.riaoojrfvvhotyaogoi0wr7okse
        posterTable[movieList[3].title]=R.drawable.zgvbrulkupqpbwginedkjpyqum4
        posterTable[movieList[4].title]=R.drawable.t7xhp8sqtvanzecvn1oqrvwcxti
        posterTable[movieList[5].title]=R.drawable.q719jxxezooyaps6babgknononx
        posterTable[movieList[6].title]=R.drawable.hek3koduyrqk7fihpxsa6mt2zc3
        posterTable[movieList[7].title]=R.drawable.h1b7tw0t399vdjacwjh8m87469b
        posterTable[movieList[8].title]=R.drawable.velwphvmqeqkcxggneu8ymio52r
        posterTable[movieList[9].title]=R.drawable.plnlrtbuult0rh3xsjmpubiso3l

    }


    override fun getItem(p0: Int): Fragment {
    var position=p0
    if(p0<0) {
    position=0
    }
    if(p0>movieList.size){
        position=movieList.size-1
    }
    var movie =movieList[position]
    var posterid:Int= posterTable[movieList[position].title]!!
    return ViewPager1Fragment.newInstance(movie,posterid)




    }

    override fun getCount(): Int {
        return movieList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return movieList[position].title
    }
}