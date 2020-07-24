package com.vigneshtheagarajan.realmdemo.viewModel

import androidx.lifecycle.ViewModel
import com.vigneshtheagarajan.realmdemo.model.Task
import io.realm.Realm

class AddTaskViewModel : ViewModel() {
    fun saveTask(title: String, des: String) {
        val task = Task(title, des)
        val realm = Realm.getDefaultInstance()

        realm.executeTransaction { realm ->
            realm.copyToRealm(task)
        }
    }
}