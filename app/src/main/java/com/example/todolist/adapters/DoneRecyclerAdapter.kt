package com.example.todolist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.model.DataItem
import com.squareup.picasso.Picasso


class DoneRecyclerAdapter() :
    RecyclerView.Adapter<DoneRecyclerAdapter.MyViewHolder>() {
    var colors = mutableListOf<Int>()
    val list:List<DataItem> = listOf<DataItem>(
        DataItem(
            "27.08.2020",
            "StartTest",
            "Hoh man","https://i.pinimg.com/originals/87/af/ef/87afef76100d0b704ca5b6039468a736.jpg"
        ),
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy","https://i.pinimg.com/originals/87/af/ef/87afef76100d0b704ca5b6039468a736.jpg"
        )
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoneRecyclerAdapter.MyViewHolder {

        val itemView = LayoutInflater.from(parent.context)
        val item = itemView.inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.colorChange()
        holder.textContainer.text = list[position].date
        holder.textContainer2.text = list[position].name
        holder.picassoHelper(list[position].img)
    }

    override fun getItemCount() = list.size


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textContainer = view.findViewById<TextView>(R.id.textViewItem)
        var textContainer2 = view.findViewById<TextView>(R.id.textViewItem2)
        var cardView = view.findViewById<CardView>(R.id.card_view)
        var img = view.findViewById<ImageView>(R.id.imageView)

        fun colorChange (){
            cardView.setBackgroundColor(colors.random())
        }

        fun picassoHelper(url: String) {

            Picasso.with(itemView.context).load(url).into(img)


        }
    }
}




