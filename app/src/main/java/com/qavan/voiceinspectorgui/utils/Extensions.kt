package com.qavan.voiceinspectorgui.utils

import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import com.qavan.voiceinspectorgui.task.Task

fun Int.emptyTask(): Task {
    val strId:String = this.toString()
    val lId:Long = strId.toLong()
    val prevValue = "10"
    val currentValue = "100"
    val prevDate = "01.01.1970"
    val currentDate = currentDate()
    return Task(
            "1234567889".toLong() + strId.toInt(), ("1234567890".toLong() + lId).toString(),
            "Фамилиев Имя Отчествович$strId", "г.Темпошторм, ул.Карлайла,\n д.2/8, кв.8",
            "", 0, ("1234567891".toLong() + lId).toString(), ("1234567892".toLong() + lId).toString(), ("1234567893".toLong() + lId).toString(),
            prevValue,currentValue,prevDate,currentDate,prevValue,currentValue,prevDate,currentDate,prevValue,currentValue,prevDate,currentDate,
            prevValue,currentValue,prevDate,currentDate,prevValue,currentValue,prevDate,currentDate,prevValue,currentValue,prevDate,currentDate,
            prevValue,currentValue,prevDate,currentDate,prevValue,currentValue,prevDate,currentDate,prevValue,currentValue,prevDate,currentDate
    )
}

fun EditText.setCursorInEnd() {
    setSelection(this.text.length)
}

fun TextView.forEditText(editText: EditText) {
    setOnClickListener {
        editText.requestFocus()
        editText.setCursorInEnd()
    }
    editText.setOnClickListener {
        editText.requestFocus()
        editText.setCursorInEnd()
    }
}

fun Switch.partnerOf(second: Switch) {
    this.setOnCheckedChangeListener { _, isChecked ->
        if (isChecked and second.isChecked) second.isChecked = false
    }
    second.setOnCheckedChangeListener { _, isChecked ->
        if (isChecked and this.isChecked) this.isChecked = false
    }
}