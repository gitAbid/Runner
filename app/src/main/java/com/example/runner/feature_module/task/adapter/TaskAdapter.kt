package com.example.runner.feature_module.task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.runner.R
import com.example.runner.feature_module.task.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter(var tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_task,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]
        holder.mTitle.text = task.title
        holder.mStatusText.text = task.status?.title
        holder.mStatusText.setTextColor(ContextCompat.getColor(context, task.status?.color!!))
        holder.mStatusContainer.background = ContextCompat.getDrawable(
            context,
            task.status.background
        )
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mTitle = view.tv_title
        val mStatusText = view.tv_status_text
        val mDueInfo = view.tv_due_information
        val mAddress = view.tv_address_information
        val mCategory = view.tv_category
        val mStatusContainer = view.ll_status_container
    }
}