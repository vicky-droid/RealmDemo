package com.vigneshtheagarajan.realmdemo.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vigneshtheagarajan.realmdemo.R
import com.vigneshtheagarajan.realmdemo.model.Task
import com.vigneshtheagarajan.realmdemo.util.RoundedBottomSheetDialogFragment
import com.vigneshtheagarajan.realmdemo.viewModel.AddTaskViewModel
import io.realm.Realm
import kotlinx.android.synthetic.main.add_task_fragment.*
import kotlin.math.log

class AddTaskFragment : RoundedBottomSheetDialogFragment() {

    companion object {
        fun newInstance() = AddTaskFragment()
    }

    private lateinit var viewModel: AddTaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_task_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddTaskViewModel::class.java)
        listner()
    }

    private fun listner() {
        btn_save.setOnClickListener {
            viewModel.saveTask(title.text.toString(), des.text.toString())
        }

    }

}