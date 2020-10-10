package com.example.homework_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_view_pager1.*
import java.io.Serializable


private const val ARG_MOV1 = "movie"
private const val ARG_MOV2 = "posterid"
class ViewPager1Fragment : Fragment() {

    private var movie: MovieData? = null
    private var posterid:Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString()
            movie = it.getSerializable(ARG_MOV1) as MovieData
            posterid = it.getInt(ARG_MOV2)
        }
//        movieTitle.text=movie!!.title
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieTitle.text=movie!!.title
        release_date.text=movie!!.release_date
        stars.text=movie!!.stars
        ratingBar.rating= movie!!.vote_average.toFloat()/2
        overview.text=movie!!.overview
        poster.setImageResource(posterid)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        movieTitle.text=movie!!.title
        return inflater.inflate(R.layout.fragment_view_pager1, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(movie: MovieData, posterid: Int) =
            ViewPager1Fragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_MOV1, movie as Serializable)
                    putInt(ARG_MOV2, posterid)
//                    putString("t", t)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }

}