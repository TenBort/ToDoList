package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.todolist.BaseViewModel
import com.example.todolist.R
import com.example.todolist.model.Task
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    private val viewModel: BaseViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.oneTaskLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            detailView(it)
        })
    }

    fun detailView(task: Task) {
        detailTextDate.text = task.date
        detailTextName.text = task.name
        detailTextDescript.text = task.description
    }


}