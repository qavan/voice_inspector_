package com.qavan.voiceinspectorgui

import android.app.Application
import com.qavan.voiceinspectorgui.task.DaoMaster
import com.qavan.voiceinspectorgui.task.DaoSession
import org.greenrobot.greendao.database.Database

class App:Application() {
    lateinit var daoSession:DaoSession

    override fun onCreate() {
        super.onCreate()
        val helper:DaoMaster.DevOpenHelper = DaoMaster.DevOpenHelper(this,"tasks_db")
        val db: Database = helper.writableDb
        daoSession = DaoMaster(db).newSession()
    }
}