package com.example.homework_3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_movie_choice.*




class MovieChoiceFragment : Fragment() {
    private var listener: onFlowActivityListener? = null



    fun onButtonPressed(v: View) {
        listener?.onBookSelect(v)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is onFlowActivityListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnMasterDetailListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie1.setOnClickListener { onButtonPressed(it) }
        movie2.setOnClickListener { onButtonPressed(it) }
        movie3.setOnClickListener { onButtonPressed(it) }
    }
    interface onFlowActivityListener {
        fun onBookSelect(v: View)
    }



}