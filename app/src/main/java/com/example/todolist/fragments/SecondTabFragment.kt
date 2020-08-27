package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapters.DoneRecyclerAdapter
import com.example.todolist.R
import kotlinx.android.synthetic.main.fragment_second_tab.*

class SecondTabFragment : Fragment() {

    val adapterRecycler = DoneRecyclerAdapter()
    val  colorsBuble = adapterRecycler.colors

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_tab, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        RecyclerViewSecond.layoutManager = LinearLayoutManager(context)
        RecyclerViewSecond.adapter = adapterRecycler

        val colorsInResours = resources.getIntArray(R.array.color_list)
        colorsInResours.forEach{
            colorsBuble.add(it)
        }
    }
}