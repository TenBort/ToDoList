package com.example.todolist.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.Adapters.ToDoRecyclerAdapter
import com.example.todolist.R
import kotlinx.android.synthetic.main.fragment_first_tab.*

class FirstTabFragment : Fragment()
{
    val adapterRecycler = ToDoRecyclerAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_tab, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        RecyclerViewFirst.layoutManager = LinearLayoutManager(context)
        RecyclerViewFirst.adapter = adapterRecycler
    }
}