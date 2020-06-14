package com.qavan.voiceinspectorgui.popup

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.qavan.voiceinspectorgui.R

class PopupNumbersWindow:View.OnTouchListener {
    private lateinit var popupWindow:PopupWindow
    @SuppressLint("InflateParams")
    fun showPopupWindow(view:View, strings:Array<String>) {
        val inflater = view.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.card_numbers, null)

        popupWindow = PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,true)
        popupWindow.showAsDropDown(popupView, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL,10)

        popupView.findViewById<TextView>(R.id.id_window_gvs).text = StringBuilder().append("№ ").append(strings[0])
        popupView.findViewById<TextView>(R.id.id_window_hvs).text = StringBuilder().append("№ ").append(strings[1])
        popupView.findViewById<TextView>(R.id.id_window_ele).text = StringBuilder().append("№ ").append(strings[2])

        popupView.setOnTouchListener(this)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        popupWindow.dismiss()
        return true
    }
}