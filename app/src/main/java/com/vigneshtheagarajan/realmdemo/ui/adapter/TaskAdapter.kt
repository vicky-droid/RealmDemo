package com.vigneshtheagarajan.realmdemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vigneshtheagarajan.realmdemo.R
import com.vigneshtheagarajan.realmdemo.model.Task
import kotlinx.android.synthetic.main.layout_cell.view.*

class TaskAdapter(val contactList: ArrayList<Task>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_cell, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: TaskAdapter.ViewHolder, position: Int) {
        holder.bindItems(contactList[position])
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: Task) {
            itemView.apply {
                title.text = user.tilte
                des.text = user.description
            }

        }
    }
}