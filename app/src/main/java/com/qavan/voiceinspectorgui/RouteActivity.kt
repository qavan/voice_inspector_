package com.qavan.voiceinspectorgui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qavan.voiceinspectorgui.popup.PopupFilterWindow
import com.qavan.voiceinspectorgui.task.*
import com.qavan.voiceinspectorgui.utils.*
import org.greenrobot.greendao.query.Query
import org.greenrobot.greendao.query.QueryBuilder

class RouteActivity:AppCompatActivity() {
    private val _settings = "settings"

    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var settings: Settings
    lateinit var filterSettings: Settings

    private val themeManager: ThemeManager = ThemeManager()
    private var currentTheme:Byte? = null

    private lateinit var tasks:List<Task>
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var tasksQuery: Query<Task>
    private lateinit var taskDao: TaskDao

    val context:Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route)

        settings = Settings.GlobalSettings(this,_settings)
        currentTheme = themeManager.getCurrentTheme(this)
        if (currentTheme == (-1).toByte()) Toast.makeText(this, "Темная тема не поддерживается на вашем устройстве", Toast.LENGTH_LONG).show()

        findViewById<TextView>(R.id.editText).setOnClickListener{
            val offset = 1000
            val from:Int = taskDao.loadAll().size
            val to:Int = from + 2
            for (i in from..to) taskDao.insert((i+offset).emptyTask())
            updateTasks(tasksQuery,taskAdapter)
        }

        findViewById<ImageView>(R.id.idIV_Filter).setOnClickListener{
            PopupFilterWindow(this,this).showPopupWindow(it)
        }

        findViewById<ImageView>(R.id.settings).setOnClickListener{
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        tasks = ArrayList()
        taskAdapter = TaskAdapter(tasks, this)

        recyclerView = findViewById(R.id.idRouteRecyclerView)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = taskAdapter

        val mDaoSession:DaoSession = (application as App).daoSession
        taskDao = mDaoSession.taskDao

        filterSettings = Settings(this,"filter", Context.MODE_PRIVATE)

        updateByFilter(this)
    }

    override fun onStart() {
        super.onStart()
        requestPermission(this, applicationContext, android.Manifest.permission.INTERNET)
    }

    override fun onResume() {
        if (themeManager.getCurrentTheme(this) != currentTheme) recreate()
        super.onResume()
        requestPermission(this, applicationContext, android.Manifest.permission.INTERNET)
        updateByFilter(this)
    }

    override fun onRestart() {
        super.onRestart()
        requestPermission(this, applicationContext, android.Manifest.permission.INTERNET)
    }

    companion object {
        private fun resetRecycleView(routeActivity: RouteActivity) {
            routeActivity.recyclerView.adapter = null
            routeActivity.recyclerView.layoutManager = null
            routeActivity.recyclerView.adapter = routeActivity.taskAdapter
            routeActivity.recyclerView.layoutManager = routeActivity.linearLayoutManager
            routeActivity.taskAdapter.notifyDataSetChanged()
        }

        fun updateByFilter(routeActivity: RouteActivity) {
            var taskQuery:QueryBuilder<Task> = routeActivity.taskDao.queryBuilder()
            if (routeActivity.filterSettings.isYes("accepted")) taskQuery = taskQuery.where(TaskDao.Properties.C_client_status.eq(0))
            else if (routeActivity.filterSettings.isNo("accepted")) taskQuery = taskQuery.where(TaskDao.Properties.C_client_status.notEq(0))

            if (routeActivity.filterSettings.isYes("paused")) taskQuery = taskQuery.where(TaskDao.Properties.C_client_status.eq(1))
            else if (routeActivity.filterSettings.isNo("paused")) taskQuery = taskQuery.where(TaskDao.Properties.C_client_status.notEq(1))

            if (routeActivity.filterSettings.isYes("dropped")) taskQuery = taskQuery.where(TaskDao.Properties.C_client_status.eq(2))
            else if (routeActivity.filterSettings.isNo("dropped")) taskQuery = taskQuery.where(TaskDao.Properties.C_client_status.notEq(2))

            if (routeActivity.filterSettings.isYes("with-note")) taskQuery = taskQuery.where(TaskDao.Properties.C_client_note.notEq(""))
            else if (routeActivity.filterSettings.isNo("with-note")) taskQuery = taskQuery.where(TaskDao.Properties.C_client_status.eq(""))

            routeActivity.tasksQuery = taskQuery.orderAsc(TaskDao.Properties.Task_id).build()
            updateTasks(routeActivity.tasksQuery, routeActivity.taskAdapter)
            resetRecycleView(routeActivity)
        }

        fun taskDao(routeActivity: RouteActivity):TaskDao {
            return routeActivity.taskDao
        }
    }
}
