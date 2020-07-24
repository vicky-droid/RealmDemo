package com.vigneshtheagarajan.realmdemo.base

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class myApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("myrealm.realm")
                /** optional if you need*/
//            .encryptionKey(getKey())
            .build()
        Realm.setDefaultConfiguration(config)
    }

}