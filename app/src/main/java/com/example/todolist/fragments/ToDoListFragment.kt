package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todolist.adapters.MyPagerAdapter
import com.example.todolist.R
import kotlinx.android.synthetic.main.fragment_to_do_list.*

class ToDoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val fragmentAdapter =
            MyPagerAdapter(
                childFragmentManager,
                2
            )
        viewpager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewpager)
    }
}