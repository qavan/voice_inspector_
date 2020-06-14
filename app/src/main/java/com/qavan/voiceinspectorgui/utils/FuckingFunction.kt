package com.qavan.voiceinspectorgui.utils

import android.widget.EditText
import android.widget.RadioGroup
import com.qavan.voiceinspectorgui.task.Task

fun check(peak: String, half_peak: String, night: String, editText: EditText, radioGroup: RadioGroup, id_f: Int, id_s: Int, id_t: Int): Boolean {
    if (radioGroup.checkedRadioButtonId == id_t) {
        if ((peak != "") and (peak != "") and (half_peak != "") and (half_peak != "") and (editText.text.toString() != "") and (editText.text.toString() != "")) {
            return (peak.toLong() > 0) and (half_peak.toLong() > 0) and (editText.text.toString().toLong() > 0)
        }
    } else if (radioGroup.checkedRadioButtonId == id_s) {
        if ((peak != "") and (peak != "") and (night != "") and (night != "") and (editText.text.toString() != "") and (editText.text.toString() != "")) {
            return (peak.toLong() > 0) and (night.toLong() > 0) and (editText.text.toString().toLong() > 0)
        }
    } else if (radioGroup.checkedRadioButtonId == id_f) {
        if ((night != "") and (night != "") and (half_peak != "") and (half_peak != "") and (editText.text.toString() != "") and (editText.text.toString() != "")) {
            return (night.toLong() > 0) and (half_peak.toLong() > 0) and (editText.text.toString().toLong() > 0)
        }
    }
    return false
}

fun updateGvsNight(task: Task, string: String) {
    task.c_gvs_night_prev_value = task.c_gvs_night_current_value
    task.c_gvs_night_current_value = string
    task.c_gvs_night_prev_date = task.c_gvs_night_current_date
    task.c_gvs_night_current_date = currentDate()
}

fun updateGvsHalfPeak(task: Task, string: String) {
    task.c_gvs_half_peak_prev_value = task.c_gvs_half_peak_current_value
    task.c_gvs_half_peak_current_value = string
    task.c_gvs_half_peak_prev_date = task.c_gvs_half_peak_current_date
    task.c_gvs_half_peak_current_date = currentDate()
}

fun updateGvsPeak(task: Task, string: String) {
    task.c_gvs_peak_prev_value = task.c_gvs_peak_current_value
    task.c_gvs_peak_current_value = string
    task.c_gvs_peak_prev_date = task.c_gvs_peak_current_date
    task.c_gvs_peak_current_date = currentDate()
}

fun updateHvsNight(task: Task, string: String) {
    task.c_hvs_night_prev_value = task.c_hvs_night_current_value
    task.c_hvs_night_current_value = string
    task.c_hvs_night_prev_date = task.c_hvs_night_current_date
    task.c_hvs_night_current_date = currentDate()
}

fun updateHvsHalfPeak(task: Task, string: String) {
    task.c_hvs_half_peak_prev_value = task.c_hvs_half_peak_current_value
    task.c_hvs_half_peak_current_value = string
    task.c_hvs_half_peak_prev_date = task.c_hvs_half_peak_current_date
    task.c_hvs_half_peak_current_date = currentDate()
}

fun updateHvsPeak(task: Task, string: String) {
    task.c_hvs_peak_prev_value = task.c_hvs_peak_current_value
    task.c_hvs_peak_current_value = string
    task.c_hvs_peak_prev_date = task.c_hvs_peak_current_date
    task.c_hvs_peak_current_date = currentDate()
}

fun updateEleNight(task: Task, string: String) {
    task.c_ele_night_prev_value = task.c_ele_night_current_value
    task.c_ele_night_current_value = string
    task.c_ele_night_prev_date = task.c_ele_night_current_date
    task.c_ele_night_current_date = currentDate()
}

fun updateEleHalfPeak(task: Task, string: String) {
    task.c_ele_half_peak_prev_value = task.c_ele_half_peak_current_value
    task.c_ele_half_peak_current_value = string
    task.c_ele_half_peak_prev_date = task.c_ele_half_peak_current_date
    task.c_ele_half_peak_current_date = currentDate()
}

fun updateElePeak(task: Task, string: String) {
    task.c_ele_peak_prev_value = task.c_ele_peak_current_value
    task.c_ele_peak_current_value = string
    task.c_ele_peak_prev_date = task.c_ele_peak_current_date
    task.c_ele_peak_current_date = currentDate()
}

fun updateGvs(task: Task, peak: String, half_peak: String, night: String, editText: EditText, radioGroup: RadioGroup, id_f: Int, id_s: Int, id_t: Int) {
    when (radioGroup.checkedRadioButtonId) {
        id_t -> {
            updateGvsNight(task, editText.text.toString())
            updateGvsPeak(task, peak)
            updateGvsHalfPeak(task, half_peak)
        }
        id_s -> {
            updateGvsNight(task, night)
            updateGvsPeak(task, peak)
            updateGvsHalfPeak(task, editText.text.toString())
        }
        id_f -> {
            updateGvsNight(task, night)
            updateGvsPeak(task, editText.text.toString())
            updateGvsHalfPeak(task, half_peak)
        }
    }
}

fun updateHvs(task: Task, peak: String, half_peak: String, night: String, editText: EditText, radioGroup: RadioGroup, id_f: Int, id_s: Int, id_t: Int) {
    when (radioGroup.checkedRadioButtonId) {
        id_t -> {
            updateHvsNight(task, editText.text.toString())
            updateHvsPeak(task, peak)
            updateHvsHalfPeak(task, half_peak)
        }
        id_s -> {
            updateHvsNight(task, night)
            updateHvsPeak(task, peak)
            updateHvsHalfPeak(task, editText.text.toString())
        }
        id_f -> {
            updateHvsNight(task, night)
            updateHvsPeak(task, editText.text.toString())
            updateHvsHalfPeak(task, half_peak)
        }
    }
}

fun updateEle(task: Task, first: String, second: String, three: String, editText: EditText, radioGroup: RadioGroup, id_f: Int, id_s: Int, id_t: Int) {
    when (radioGroup.checkedRadioButtonId) {
        id_t -> {
            updateEleNight(task, editText.text.toString())
            updateElePeak(task, first)
            updateEleHalfPeak(task, second)
        }
        id_s -> {
            updateEleNight(task, three)
            updateElePeak(task, first)
            updateEleHalfPeak(task, editText.text.toString())
        }
        id_f -> {
            updateEleNight(task, three)
            updateElePeak(task, editText.text.toString())
            updateEleHalfPeak(task, second)
        }
    }
}