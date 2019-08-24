package com.example.runner.feature_module.task.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.runner.R
import com.example.runner.feature_module.task.adapter.TaskAdapter
import com.example.runner.feature_module.task.model.Task
import kotlinx.android.synthetic.main.custom_topbar.*
import kotlinx.android.synthetic.main.fragment_task.*

/**
 * A simple [Fragment] subclass.
 */
class TaskFragment : Fragment() {
    private lateinit var task: ArrayList<Task>
    lateinit var taskAdapter: TaskAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvActionBarTitle.text = getText(R.string.task_text)

        task = arrayListOf()
        for (i in 1..6) {
            var status = Task.Status.fromId(i)
            task.add(
                Task(
                    id = i.toLong(),
                    title = "What is Lorem Ipsum?",
                    description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an ",
                    status = status,
                    category = "",
                    dueOn = 0L,
                    lastUpdated = 0L
                )
            )

        }

        taskAdapter = TaskAdapter(task)
        rcvTask.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = taskAdapter;
        }
    }
}
