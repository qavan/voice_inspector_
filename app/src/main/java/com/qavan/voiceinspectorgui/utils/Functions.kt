package com.qavan.voiceinspectorgui.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.qavan.voiceinspectorgui.task.TaskAdapter
import com.qavan.voiceinspectorgui.task.Task
import org.greenrobot.greendao.query.Query
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun currentDate():String {
    return SimpleDateFormat("dd.MM.yyyy").format(Date())
}

fun updateTasks(taskQuery: Query<Task>, taskAdapter: TaskAdapter) {
    taskAdapter.setTask(taskQuery.list())
}

fun requestPermission(activity: Activity, context: Context, permission: String) {
    if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
        Toast.makeText(context,"Предоставьте требуемые разрешения для приложения", Toast.LENGTH_SHORT).show()
        ActivityCompat.requestPermissions(activity, arrayOf(permission),1)
    }
}