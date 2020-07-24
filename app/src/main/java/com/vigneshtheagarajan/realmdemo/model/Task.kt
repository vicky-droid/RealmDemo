package com.vigneshtheagarajan.realmdemo.model

import android.accounts.AuthenticatorDescription
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Task (var tilte:String="",var description: String="") : RealmObject()

