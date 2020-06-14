package com.qavan.voiceinspectorgui.task

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qavan.voiceinspectorgui.CardActivity
import com.qavan.voiceinspectorgui.R
import com.qavan.voiceinspectorgui.RouteActivity
import com.qavan.voiceinspectorgui.popup.PopupNoteWindow
import com.qavan.voiceinspectorgui.utils.Settings

class TaskAdapter internal constructor(private var tasksDataset:List<Task>, private val routeActivity: Activity): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    private val theme = "DARK"
    private var settings: Settings.GlobalSettings = Settings.GlobalSettings(routeActivity, "settings")
    private var strGreen: String
    private var strOrange: String
    private var strRed: String
    init {
        if (settings.isYes(theme)) {
            strGreen = "#14C93C"
            strOrange = "#E1A020"
            strRed = "#E43939"
        } else {
            strGreen = "#53AB78"
            strOrange = "#DF9C61"
            strRed = "#E17575"
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val iconAcceptedFileName = "icon_accepted_sand"
        val iconPausedFileName = "icon_paused_sand"
        val iconDroppedFileName = "icon_dropped_sand"
        val task:Task = tasksDataset[position]
        val intStatus = task.c_client_status
        val strNote = task.c_client_note
        holder.tvStatusTitle.text = StringBuilder().append("пп №").append(task.task_id)

        if (strNote != "") {
            holder.tvNoteText.text = strNote
            holder.tvNoteText.visibility = (View.VISIBLE)
        } else holder.tvNoteText.visibility = (View.GONE)

        when (intStatus) {
            0 -> mark(holder.tvStatusTitle,holder.btnStatus,strGreen,iconPausedFileName)
            1 -> mark(holder.tvStatusTitle,holder.btnStatus,strOrange,iconDroppedFileName)
            2 -> mark(holder.tvStatusTitle,holder.btnStatus,strRed,iconAcceptedFileName)
        }

        holder.tvAddress.text = task.c_client_address
        holder.tvFIO.text = task.c_client_fio
        holder.tvLS.text = StringBuilder().append("лс №").append(task.c_client_ls)
        holder.tvRemainDate.text = StringBuilder().append("До ").append(task.c_ele_night_prev_date)

        holder.btnNote.setOnClickListener {
            PopupNoteWindow(routeActivity as RouteActivity).showPopupWindow(it, routeActivity, task.task_id.toString(), task.c_client_note)
        }

        holder.btnStatus.setOnClickListener{
            when (task.c_client_status) {
                0 -> {
                    mark(holder.tvStatusTitle,holder.btnStatus,strOrange,iconDroppedFileName)
                    task.c_client_status = 1
                }
                1 -> {
                    mark(holder.tvStatusTitle,holder.btnStatus,strRed,iconAcceptedFileName)
                    task.c_client_status = 2
                }
                2 -> {
                    mark(holder.tvStatusTitle,holder.btnStatus,strGreen,iconPausedFileName)
                    task.c_client_status = 0
                }
            }
            RouteActivity.updateByFilter(routeActivity as RouteActivity)
            task.update()
        }
    }

    class ViewHolder constructor(itemView: View, private val tasksDataset: List<Task>, private val activity: Activity): RecyclerView.ViewHolder(itemView) {
        val tvStatusTitle: TextView = itemView.findViewById(R.id.idTVTitle)
        val tvNoteText: TextView = itemView.findViewById(R.id.idTVNote)
        val tvAddress: TextView = itemView.findViewById(R.id.idTVAddress)
        val tvFIO: TextView = itemView.findViewById(R.id.idTVFIO)
        val tvLS: TextView = itemView.findViewById(R.id.idTVLS)
        val tvRemainDate: TextView = itemView.findViewById(R.id.idTV_Date)
        val btnStatus: ImageButton = itemView.findViewById(R.id.id_status_button)
        val btnNote: ImageButton = itemView.findViewById(R.id.id_note_button)
        init {
            itemView.setOnClickListener {
                activity.startActivity(Intent((activity as RouteActivity).context, CardActivity::class.java).putExtra("task_id",tasksDataset[layoutPosition].task_id))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.route_task, parent, false), tasksDataset, routeActivity)
    }

    override fun getItemCount(): Int {
        return tasksDataset.size
    }

    fun setTask(tasks: List<Task>) {
        this.tasksDataset = tasks
        notifyDataSetChanged()
    }

    private fun mark(statusTitle:TextView, status:ImageButton, color:String, iconName:String) {
        statusTitle.setTextColor(Color.parseColor(color))
        status.setImageResource((routeActivity as RouteActivity).context.resources.getIdentifier(iconName, "drawable", routeActivity.context.packageName))
    }
}