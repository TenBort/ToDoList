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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentAdapter =
            MyPagerAdapter(
                childFragmentManager,
                2
            )
        viewpager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewpager)

        tabs.getTabAt(0)?.setIcon(R.drawable.ic_baseline_sentiment_satisfied_24)
        tabs.getTabAt(1)?.setIcon(R.drawable.ic_baseline_sentiment_very_satisfied_24)

    }
}