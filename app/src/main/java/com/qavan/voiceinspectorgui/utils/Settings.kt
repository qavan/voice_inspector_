package com.qavan.voiceinspectorgui.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

open class Settings constructor(activity:Activity, nameOfSettingsStorage:String, mode:Int) {
    private val tag:String = "SETTINGS"
    private var preferences:SharedPreferences = activity.getSharedPreferences(nameOfSettingsStorage,mode)
    private var editor:SharedPreferences.Editor? = null

    @SuppressLint("CommitPrefEdits")
    fun initEditor() {
        if (this.editor != null) Log.w(tag, "SharedPreferences.Editor been overwritten")
        this.editor = this.preferences.edit()
    }

    fun saveChanges() {
        if (this.editor != null) {
            this.editor!!.apply()
            this.editor!!.commit()
        } else Log.e(tag, "Initialize Editor before adding/editing! Look: initEditor!")
    }

    fun add(nameOfSetting:String,valueOfSetting:String) {
        if (this.editor != null) {
            this.editor!!.putString(nameOfSetting,valueOfSetting)
        }
        else Log.e(tag, "Initialize Editor before adding/editing! Look: initEditor!")
    }

    fun get(nameOfSetting: String):String? {
        val defValueOfReturn = "none"
        return this.preferences.getString(nameOfSetting,defValueOfReturn)
    }

    fun isYes(nameOfSetting: String):Boolean {
        return this.get(nameOfSetting).equals("yes")
    }

    fun isNo(nameOfSetting: String):Boolean {
        return this.get(nameOfSetting).equals("no")
    }

    class Filter constructor(activity:Activity, nameOfSettingsStorage:String):Settings(activity, nameOfSettingsStorage, Context.MODE_PRIVATE)
    class GlobalSettings constructor(activity:Activity, nameOfSettingsStorage:String):Settings(activity, nameOfSettingsStorage, Context.MODE_PRIVATE)
}