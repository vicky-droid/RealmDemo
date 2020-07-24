package com.vigneshtheagarajan.realmdemo

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vigneshtheagarajan.realmdemo.model.Task
import com.vigneshtheagarajan.realmdemo.ui.AddTaskFragment
import com.vigneshtheagarajan.realmdemo.ui.adapter.TaskAdapter
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val realm = Realm.getDefaultInstance()
    val list = ArrayList<Task>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listner()
        setAdapter()
    }

    private fun setAdapter() {
        rv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = TaskAdapter(list)
        }
    }

    private fun listner() {
        floatingActionButton.setOnClickListener {
            val fragment = AddTaskFragment()
            fragment.show(supportFragmentManager, fragment.tag)
        }

        val result = realm.where(Task::class.java).findAllAsync()
        result.addChangeListener { results ->
            val resultArray: Array<Task> =
                results.toArray() as Array<Task>

            results.forEach {
                Log.d("data001", "$it")
                if (!list.contains(it))
                    list.add(it)
            }
            rv.adapter?.notifyDataSetChanged()

        }

    }

}