package com.example.todolist.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R

class RecyclerAdapter (private val myDataset: Array<String>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): RecyclerAdapter.MyViewHolder {

            val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_first_tab, parent, false) as TextView


            return MyViewHolder(textView)
        }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myDataset[position]
    }

    override fun getItemCount() = myDataset.size
}




