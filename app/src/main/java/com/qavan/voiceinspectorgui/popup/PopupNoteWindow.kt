package com.qavan.voiceinspectorgui.popup

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Button
import android.widget.Toast
import android.widget.PopupWindow
import com.qavan.voiceinspectorgui.R
import com.qavan.voiceinspectorgui.RouteActivity
import com.qavan.voiceinspectorgui.RouteActivity.Companion.updateByFilter
import com.qavan.voiceinspectorgui.task.Task
import com.qavan.voiceinspectorgui.task.TaskDao
import com.qavan.voiceinspectorgui.utils.setCursorInEnd

class PopupNoteWindow constructor(private val routeActivity: RouteActivity) {
    @SuppressLint("InflateParams")
    fun showPopupWindow(view: View, activity: Activity, title:String, noteValue:String) {
        val inflater = view.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.route_note, null)

        val popupWindow = PopupWindow(popupView,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,true)
        popupWindow.showAsDropDown(popupView,Gravity.CENTER_HORIZONTAL,Gravity.CENTER_VERTICAL,10)

        popupView.findViewById<TextView>(R.id.idTV_PopUpWindowTitle).text = StringBuilder().append("заметка для №").append(title)

        val editTextNote = popupView.findViewById<EditText>(R.id.idET_PopUpWindowNote)
        editTextNote.setText(StringBuilder().append(noteValue))
        editTextNote.setCursorInEnd()

        popupView.findViewById<Button>(R.id.idB_PopUpWindowButton).setOnClickListener {
            val taskDao:TaskDao = RouteActivity.taskDao(routeActivity)
            val task:Task = taskDao.queryBuilder().where(TaskDao.Properties.Task_id.eq(title)).build().list()[0]
            task.c_client_note = editTextNote.text.toString()
            task.update()
            Toast.makeText(activity.applicationContext,"Заметка записана",Toast.LENGTH_SHORT).show()
            updateByFilter(routeActivity)
            popupWindow.dismiss()
        }
        popupView.setOnClickListener{popupWindow.dismiss()}
    }
}