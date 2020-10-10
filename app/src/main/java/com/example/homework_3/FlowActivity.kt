package com.example.homework_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_movie_choice.*


class FlowActivity : AppCompatActivity(),MovieChoiceFragment.onFlowActivityListener {

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
    private var mTwoPane = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        movie1.tag=0
//        movie2.tag=1
//        movie3.tag=2
        val y = resources.configuration.screenHeightDp
        val x = resources.configuration.screenWidthDp
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.phone,MovieChoiceFragment()).commit()
        }
        if(findViewById<FrameLayout>(R.id.tablet) != null){
            mTwoPane = true // Tablet layout is loaded
        }

    }

    override fun onBookSelect(v: View) {
        lateinit var fragment:ViewPager1Fragment
        lateinit var title:String
        if(v.javaClass.name.contains("TextView",ignoreCase = true)){
            title = findViewById<TextView>(v.id).text.toString()
        }
        else{
            title = findViewById<Button>(v.id).text.toString()
        }
//        if(v.tag==2){
//            title = findViewById<TextView>(v.id).text.toString()
//        }
//        else{
//            title = findViewById<Button>(v.id).text.toString()
//        }
//        title = findViewById<Button>(v.id).text.toString()
        var i=0

        while(i!=10){
            if(title==movieList[i].title){
                break
            }
            else{
                i++
            }
        }
        if(title==movieList[i].title){
            fragment = ViewPager1Fragment.newInstance(movieList[i],
                posterTable[movieList[i].title]!!
            )
        }
//        val fragment = DetailFragment.newInstance(title)
//
        if (mTwoPane) {
            supportFragmentManager.beginTransaction().replace(R.id.tablet, fragment).addToBackStack(null).commit()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.phone, fragment).addToBackStack(null).commit()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}


