package com.ucb.examen2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostListAdapter(val list: ArrayList<Post>, val mainActivity: MainActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.book_row,parent,false)
        return PostListViewHolder(view)
    }

    class PostListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item= list.get(position)
        //holder.itemView.findViewById<TextView>(R.id.tv_idBook).text=item.id
        holder.itemView.findViewById<TextView>(R.id.tv_titleBook).text=item.title
        holder.itemView.findViewById<TextView>(R.id.tv_bodyBook).text=item.body
        //holder.itemView.findViewById<TextView>(R.id.tv_userId).text=item.userId

    }

}
