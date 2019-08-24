package com.example.runner.feature_module.task.model

import com.example.runner.R


class Task(
    val id: Long,
    val title: String,
    val description: String,
    val dueOn: Long,
    val status: Status?,
    val category: String,
    val lastUpdated: Long
) {
    enum class Status(val id: Int, val title: String, val color: Int, val background: Int) {
        NEW(1, "New", R.color.colorGrey, R.drawable.new_background),
        IN_PROGRESS(2, "In Progress", R.color.colorBlue, R.drawable.in_progress_background),
        DENIED(3, "Denied", R.color.colorRed, R.drawable.denied_background),
        DELAYED(4, "Delayed", R.color.colorYellow, R.drawable.delayed_background),
        COMPLETED(5, "Completed", R.color.colorGreen, R.drawable.completed_background),
        POSTPONED(6, "Postponed", R.color.colorOrange, R.drawable.postponed_background);

        companion object {
            private val map = values().associateBy(Status::id)
            fun fromId(type: Int) = map[type]
        }
    }
}