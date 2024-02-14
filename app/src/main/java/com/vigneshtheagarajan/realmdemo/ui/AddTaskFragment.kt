package com.vigneshtheagarajan.realmdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vigneshtheagarajan.realmdemo.databinding.AddTaskFragmentBinding
import com.vigneshtheagarajan.realmdemo.util.RoundedBottomSheetDialogFragment
import com.vigneshtheagarajan.realmdemo.viewModel.AddTaskViewModel

class AddTaskFragment : RoundedBottomSheetDialogFragment() {
    private var _binding: AddTaskFragmentBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = AddTaskFragment()
    }

    private lateinit var viewModel: AddTaskViewModel

    override fun onCreateView(  inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {
        _binding = AddTaskFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddTaskViewModel::class.java)
        listner()
    }

    private fun listner() {
        binding.btnSave.setOnClickListener {
            viewModel.saveTask(binding.title.text.toString(), binding.des.text.toString())
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}