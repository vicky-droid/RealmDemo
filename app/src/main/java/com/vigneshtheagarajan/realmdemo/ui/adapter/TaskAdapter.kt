package com.vigneshtheagarajan.realmdemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vigneshtheagarajan.realmdemo.databinding.ItemCellBinding
import com.vigneshtheagarajan.realmdemo.model.Task

class TaskAdapter(val contactList: ArrayList<Task>) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.ViewHolder {
        val itemBinding = ItemCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val v = itemBinding.root
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TaskAdapter.ViewHolder, position: Int) {
        holder.bindItems(contactList[position])
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    class ViewHolder(private val itemBinding: ItemCellBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindItems(user: Task) {
            itemView.apply {
                itemBinding.title.text = user.tilte
                itemBinding.des.text = user.description
            }
        }
    }
}