package com.qavan.voiceinspectorgui.popup

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Switch
import com.qavan.voiceinspectorgui.R
import com.qavan.voiceinspectorgui.RouteActivity
import com.qavan.voiceinspectorgui.utils.Settings
import com.qavan.voiceinspectorgui.utils.partnerOf

class PopupFilterWindow constructor(activity: Activity, private val routeActivity: RouteActivity):View.OnTouchListener {
    private val filter:Settings.Filter = Settings.Filter(activity, "filter")
    private lateinit var popupWindow: PopupWindow
    @SuppressLint("InflateParams")
    fun showPopupWindow(view: View) {
        val inflater = view.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.route_filter, null)

        popupWindow = PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,true)
        popupWindow.showAsDropDown(popupView, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL,10)

        val switchAcceptedY:Switch = popupView.findViewById(R.id.idS_FilterAcceptedYes)
        val switchAcceptedN:Switch = popupView.findViewById(R.id.idS_FilterAcceptedNo)
        val switchPausedY:Switch = popupView.findViewById(R.id.idS_FilterPausedYes)
        val switchPausedN:Switch = popupView.findViewById(R.id.idS_FilterPausedNo)
        val switchDroppedY:Switch = popupView.findViewById(R.id.idS_FilterDroppedYes)
        val switchDroppedN:Switch = popupView.findViewById(R.id.idS_FilterDroppedNo)
        val switchWithNoteY:Switch = popupView.findViewById(R.id.idS_FilterWithNoteYes)
        val switchWithNoteN:Switch = popupView.findViewById(R.id.idS_FilterWithNoteNo)

        switchAcceptedY.partnerOf(switchAcceptedN)
        switchPausedY.partnerOf(switchPausedN)
        switchDroppedY.partnerOf(switchDroppedN)
        switchWithNoteY.partnerOf(switchWithNoteN)

        when {
            filter.isYes("accepted") -> switchAcceptedY.isChecked = true
            filter.isNo("accepted") -> switchAcceptedN.isChecked = true
            else -> {
                switchAcceptedY.isChecked = false
                switchAcceptedN.isChecked = false
            }
        }
        when {
            filter.isYes("paused") -> switchPausedY.isChecked = true
            filter.isNo("paused") -> switchPausedN.isChecked = true
            else -> {
                switchPausedY.isChecked = false
                switchPausedN.isChecked = false
            }
        }
        when {
            filter.isYes("dropped") -> switchDroppedY.isChecked = true
            filter.isNo("dropped") -> switchDroppedN.isChecked = true
            else -> {
                switchDroppedY.isChecked = false
                switchDroppedN.isChecked = false
            }
        }
        when {
            filter.isYes("with-note") -> switchWithNoteY.isChecked = true
            filter.isNo("with-note") -> switchWithNoteN.isChecked = true
            else -> {
                switchWithNoteY.isChecked = false
                switchWithNoteN.isChecked = false
            }
        }

        popupView.findViewById<Button>(R.id.idB_PopUpWindowButton).setOnClickListener {
            filter.initEditor()

            when {
                !switchAcceptedY.isChecked and !switchAcceptedN.isChecked -> filter.add("accepted", "none")
                switchAcceptedY.isChecked -> filter.add("accepted", "yes")
                switchAcceptedN.isChecked -> filter.add("accepted", "no")
            }
            when {
                !switchPausedY.isChecked and !switchPausedN.isChecked -> filter.add("paused", "none")
                switchPausedY.isChecked -> filter.add("paused", "yes")
                switchPausedN.isChecked -> filter.add("paused", "no")
            }
            when {
                !switchDroppedY.isChecked and !switchDroppedN.isChecked -> filter.add("dropped", "none")
                switchDroppedY.isChecked -> filter.add("dropped", "yes")
                switchDroppedN.isChecked -> filter.add("dropped", "no")
            }
            when {
                !switchWithNoteY.isChecked and !switchWithNoteN.isChecked -> filter.add("with-note", "none")
                switchWithNoteY.isChecked -> filter.add("with-note", "yes")
                switchWithNoteN.isChecked -> filter.add("with-note", "no")
            }

            filter.saveChanges()
            RouteActivity.updateByFilter(routeActivity)
            popupWindow.dismiss()
        }

        popupView.setOnTouchListener(this)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        popupWindow.dismiss()
        return true
    }
}