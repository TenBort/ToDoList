package com.example.todolist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.model.Task
import com.example.todolist.R
import com.example.todolist.fragments.FirstTabFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*
import java.util.Locale.filter


class ToDoRecyclerAdapter(private val deleteItem: (Task)->Unit,private val detailClicked: (Task)->Unit) :
    RecyclerView.Adapter<ToDoRecyclerAdapter.MyViewHolder>() {
    var colors = mutableListOf<Int>()
    var itemList: MutableList<Task> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoRecyclerAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val item = itemView.inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(item)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (position < colors.size) {
            holder.cardView.setCardBackgroundColor(colors[position])
        } else {
            holder.cardView.setCardBackgroundColor(colors.random())
        }

        holder.dateContainer.text = itemList[position].date
        holder.nameContainer.text = itemList[position].name

        holder.deleteView.setOnClickListener {
            deleteItem.invoke(itemList[position])
            notifyDataSetChanged()
        }
        holder.cardView.setOnClickListener {
            detailClicked.invoke(itemList[position])
        }
    }

    override fun getItemCount() = itemList.size


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val dateContainer = view.textViewItem!!
        val nameContainer = view.textViewItem2!!
        val cardView = view.card_view!!
        val deleteView = view.deleteView!!
        val doneView = view.doneView!!
        val specialView = view.specialView!!


    }

}




