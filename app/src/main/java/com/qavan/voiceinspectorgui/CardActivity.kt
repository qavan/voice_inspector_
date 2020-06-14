package com.qavan.voiceinspectorgui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.qavan.voiceinspectorgui.popup.PopupNumbersWindow
import com.qavan.voiceinspectorgui.task.DaoSession
import com.qavan.voiceinspectorgui.task.Task
import com.qavan.voiceinspectorgui.task.TaskDao
import com.qavan.voiceinspectorgui.utils.*

class CardActivity:AppCompatActivity() {
    private lateinit var llNote: LinearLayout; private lateinit var llNumbers:LinearLayout; private lateinit var llFio:LinearLayout; private lateinit var llAddress:LinearLayout; private lateinit var llDropper:LinearLayout
    private lateinit var tvTitle: TextView; private lateinit var tvNote:TextView; private lateinit var tvValue:TextView; private lateinit var tvFio:TextView; private lateinit var tvAddress:TextView
    private lateinit var tvGvsPrevDate: TextView; private lateinit var tvHvsPrevDate:TextView; private lateinit var tvElePrevDate:TextView
    private lateinit var tvGvsCurrentDate:TextView; private lateinit var tvHvsCurrentDate:TextView; private lateinit var tvEleCurrentDate:TextView
    private lateinit var tvGvsDate: TextView; private lateinit var tvHvsDate:TextView; private lateinit var tvEleDate:TextView
    private lateinit var tvGvsPrevValue:TextView; private lateinit var tvHvsPrevValue:TextView; private lateinit var tvElePrevValue:TextView
    private lateinit var tvGvsCurrentValue: TextView; private lateinit var tvHvsCurrentValue:TextView; private lateinit var tvEleCurrentValue:TextView
    private lateinit var etGvsValue: EditText; private lateinit var etHvsValue:EditText; private lateinit var etEleValue:EditText
    private lateinit var rgGvsGroup: RadioGroup; private lateinit var rgHvsGroup:RadioGroup; private lateinit var rgEleGroup:RadioGroup
    private lateinit var bSave: Button
    private var taskId: Long = 0
    private lateinit var strFio: String; private lateinit var strLs:String
    private lateinit var task: Task
    private lateinit var taskDao: TaskDao
    private var bInfoOpen = false
    private var idGvsCurrentRb = R.id.id_card_gvs_peak; private var idHvsCurrentRb:Int = R.id.id_card_hvs_peak; private var idEleCurrentRb:Int = R.id.id_card_ele_peak
    private var strGvsNight = ""; private var strHvsNight = ""; private var strEleNight = ""
    private var strGvsHalfPeak = ""; private var strHvsHalfPeak = ""; private var strEleHalfPeak = ""
    private var strGvsPeak = ""; private var strHvsPeak = ""; private var strElePeak = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        val daoSession:DaoSession = (application as App).daoSession
        taskDao = daoSession.taskDao

        bSave = findViewById(R.id.action)

        llNote = findViewById(R.id.id_card_LL_note)
        llNumbers = findViewById(R.id.id_card_LL_numbers)
        llFio = findViewById(R.id.id_card_LL_fio)
        llAddress = findViewById(R.id.id_card_LL_address)
        llDropper = findViewById(R.id.id_card_LL_dropper)
        tvNote = findViewById(R.id.id_card_note)
        tvTitle = findViewById(R.id.id_card_optional_title_ls_or_fio)
        tvValue = findViewById(R.id.id_card_optional_value_ls_or_fio)
        tvFio = findViewById(R.id.id_card_fio)
        tvAddress = findViewById(R.id.id_card_address)

        llNumbers.visibility = View.GONE
        llFio.visibility = View.GONE
        llAddress.visibility = View.GONE

        rgGvsGroup = findViewById(R.id.id_gvs_group)
        rgHvsGroup = findViewById(R.id.id_hvs_group)
        rgEleGroup = findViewById(R.id.id_ele_group)

        tvGvsPrevDate = findViewById(R.id.id_card_gvs_prev_date)
        tvHvsPrevDate = findViewById(R.id.id_card_hvs_prev_date)
        tvElePrevDate = findViewById(R.id.id_card_ele_prev_date)
        tvGvsCurrentDate = findViewById(R.id.id_card_gvs_current_date)
        tvHvsCurrentDate = findViewById(R.id.id_card_hvs_current_date)
        tvEleCurrentDate = findViewById(R.id.id_card_ele_current_date)
        tvGvsDate = findViewById(R.id.id_card_gvs_new_date)
        tvHvsDate = findViewById(R.id.id_card_hvs_new_date)
        tvEleDate = findViewById(R.id.id_card_ele_new_date)

        tvGvsPrevValue = findViewById(R.id.id_card_gvs_prev_value)
        tvHvsPrevValue = findViewById(R.id.id_card_hvs_prev_value)
        tvElePrevValue = findViewById(R.id.id_card_ele_prev_value)
        tvGvsCurrentValue = findViewById(R.id.id_card_gvs_current_value)
        tvHvsCurrentValue = findViewById(R.id.id_card_hvs_current_value)
        tvEleCurrentValue = findViewById(R.id.id_card_ele_current_value)

        etGvsValue = findViewById(R.id.id_card_gvs_new_value)
        etHvsValue = findViewById(R.id.id_card_hvs_new_value)
        etEleValue = findViewById(R.id.id_card_ele_new_value)

        tvGvsDate.forEditText(etGvsValue)
        tvHvsDate.forEditText(etHvsValue)
        tvEleDate.forEditText(etEleValue)

        etGvsValue.setText("")
        etHvsValue.setText("")
        etEleValue.setText("")

        taskId = intent.extras!!.getLong("task_id")
        task = taskDao.queryBuilder().where(TaskDao.Properties.Task_id.eq(taskId)).build().list()[0]

        val mNote = task.c_client_note
        if (mNote != "") {
            tvNote.text = mNote
            llNote.visibility = View.VISIBLE
        }
        else llNote.visibility = View.GONE

        llNumbers.setOnClickListener{
            PopupNumbersWindow().showPopupWindow(it, arrayOf(task.c_gvs_id, task.c_hvs_id, task.c_ele_id))
        }

        findViewById<LinearLayout>(R.id.da).setOnClickListener {
            dropperAction()
        }
    }

    override fun onResume() {
        super.onResume()

        tvTitle.text = task.c_client_ls
        tvValue.text = task.c_client_fio
        strLs = tvValue.text.toString()
        strFio = tvFio.text.toString()
        tvFio.text = strLs
        tvValue.text = strFio
        tvAddress.text = task.c_client_address

        tvGvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_gvs_peak_prev_date)
        tvHvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_hvs_peak_prev_date)
        tvElePrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_ele_peak_prev_date)

        tvGvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_gvs_peak_current_date)
        tvHvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_hvs_peak_current_date)
        tvEleCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_ele_peak_current_date)

        val currentDateD = currentDate()
        tvGvsDate.text = StringBuilder().append(getString(R.string.news)," ").append(currentDateD)
        tvHvsDate.text = StringBuilder().append(getString(R.string.news)," ").append(currentDateD)
        tvEleDate.text = StringBuilder().append(getString(R.string.news)," ").append(currentDateD)

        tvGvsPrevValue.text = StringBuilder().append(task.c_gvs_peak_prev_value)
        tvHvsPrevValue.text = StringBuilder().append(task.c_hvs_peak_prev_value)
        tvElePrevValue.text = StringBuilder().append(task.c_ele_peak_prev_value)
        
        tvGvsCurrentValue.text = StringBuilder().append(task.c_gvs_peak_current_value)
        tvHvsCurrentValue.text = StringBuilder().append(task.c_hvs_peak_current_value)
        tvEleCurrentValue.text = StringBuilder().append(task.c_ele_peak_current_value)

        rgGvsGroup.setOnCheckedChangeListener { _, checkedId ->
            if (idGvsCurrentRb == R.id.id_card_gvs_night) {
                strGvsNight = etGvsValue.text.toString()
                if (checkedId == R.id.id_card_gvs_half_peak) {
                    tvGvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_gvs_half_peak_prev_date)
                    tvGvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_gvs_half_peak_current_date)
                    tvGvsPrevValue.text = StringBuilder().append(task.c_gvs_half_peak_prev_value)
                    tvGvsCurrentValue.text = StringBuilder().append(task.c_gvs_half_peak_current_value)
                    idGvsCurrentRb = R.id.id_card_gvs_half_peak
                    etGvsValue.setText(strGvsHalfPeak)
                } else if (checkedId == R.id.id_card_gvs_peak) {
                    tvGvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_gvs_peak_prev_date)
                    tvGvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_gvs_peak_current_date)
                    tvGvsPrevValue.text = StringBuilder().append(task.c_gvs_peak_prev_value)
                    tvGvsCurrentValue.text = StringBuilder().append(task.c_gvs_peak_current_value)
                    idGvsCurrentRb = R.id.id_card_gvs_peak
                    etGvsValue.setText(strGvsPeak)
                }
            } else if (idGvsCurrentRb == R.id.id_card_gvs_half_peak) {
                strGvsHalfPeak = etGvsValue.text.toString()
                if (checkedId == R.id.id_card_gvs_night) {
                    tvGvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_gvs_night_prev_date)
                    tvGvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_gvs_night_current_date)
                    tvGvsPrevValue.text = StringBuilder().append(task.c_gvs_night_prev_value)
                    tvGvsCurrentValue.text = StringBuilder().append(task.c_gvs_night_current_value)
                    idGvsCurrentRb = R.id.id_card_gvs_night
                    etGvsValue.setText(strGvsNight)
                } else if (checkedId == R.id.id_card_gvs_peak) {
                    tvGvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_gvs_peak_prev_date)
                    tvGvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_gvs_peak_current_date)
                    tvGvsPrevValue.text = StringBuilder().append(task.c_gvs_peak_prev_value)
                    tvGvsCurrentValue.text = StringBuilder().append(task.c_gvs_peak_current_value)
                    idGvsCurrentRb = R.id.id_card_gvs_peak
                    etGvsValue.setText(strGvsPeak)
                }
            } else if (idGvsCurrentRb == R.id.id_card_gvs_peak) {
                strGvsPeak = etGvsValue.text.toString()
                if (checkedId == R.id.id_card_gvs_night) {
                    tvGvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_gvs_night_prev_date)
                    tvGvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_gvs_night_current_date)
                    tvGvsPrevValue.text = StringBuilder().append(task.c_gvs_night_prev_value)
                    tvGvsCurrentValue.text = StringBuilder().append(task.c_gvs_night_current_value)
                    idGvsCurrentRb = R.id.id_card_gvs_night
                    etGvsValue.setText(strGvsNight)
                } else if (checkedId == R.id.id_card_gvs_half_peak) {
                    tvGvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ",task.c_gvs_half_peak_prev_date)
                    tvGvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ",task.c_gvs_half_peak_current_date)
                    tvGvsPrevValue.text = StringBuilder().append(task.c_gvs_half_peak_prev_value)
                    tvGvsCurrentValue.text = StringBuilder().append(task.c_gvs_half_peak_current_value)
                    idGvsCurrentRb = R.id.id_card_gvs_half_peak
                    etGvsValue.setText(strGvsHalfPeak)
                }
            }
        }
        rgHvsGroup.setOnCheckedChangeListener { _, checkedId ->
            if (idHvsCurrentRb == R.id.id_card_hvs_night) {
                strHvsNight = etHvsValue.text.toString()
                if (checkedId == R.id.id_card_hvs_half_peak) {
                    tvHvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_hvs_half_peak_prev_date)
                    tvHvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_hvs_half_peak_current_date)
                    tvHvsPrevValue.text = StringBuilder().append(task.c_hvs_half_peak_prev_value)
                    tvHvsCurrentValue.text = StringBuilder().append(task.c_hvs_half_peak_current_value)
                    idHvsCurrentRb = R.id.id_card_hvs_half_peak
                    etHvsValue.setText(strHvsHalfPeak)
                } else if (checkedId == R.id.id_card_hvs_peak) {
                    tvHvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_hvs_peak_prev_date)
                    tvHvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_hvs_peak_current_date)
                    tvHvsPrevValue.text = StringBuilder().append(task.c_hvs_peak_prev_value)
                    tvHvsCurrentValue.text = StringBuilder().append(task.c_hvs_peak_current_value)
                    idHvsCurrentRb = R.id.id_card_hvs_peak
                    etHvsValue.setText(strHvsPeak)
                }
            } else if (idHvsCurrentRb == R.id.id_card_hvs_half_peak) {
                strHvsHalfPeak = etHvsValue.text.toString()
                if (checkedId == R.id.id_card_hvs_night) {
                    tvHvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_hvs_night_prev_date)
                    tvHvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_hvs_night_current_date)
                    tvHvsPrevValue.text = StringBuilder().append(task.c_hvs_night_prev_value)
                    tvHvsCurrentValue.text = StringBuilder().append(task.c_hvs_night_current_value)
                    idHvsCurrentRb = R.id.id_card_hvs_night
                    etHvsValue.setText(strHvsNight)
                } else if (checkedId == R.id.id_card_hvs_peak) {
                    tvHvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_hvs_peak_prev_date)
                    tvHvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_hvs_peak_current_date)
                    tvHvsPrevValue.text = StringBuilder().append(task.c_hvs_peak_prev_value)
                    tvHvsCurrentValue.text = StringBuilder().append(task.c_hvs_peak_current_value)
                    idHvsCurrentRb = R.id.id_card_hvs_peak
                    etHvsValue.setText(strHvsPeak)
                }
            } else if (idHvsCurrentRb == R.id.id_card_hvs_peak) {
                strHvsPeak = etHvsValue.text.toString()
                if (checkedId == R.id.id_card_hvs_night) {
                    tvHvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_hvs_night_prev_date)
                    tvHvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_hvs_night_current_date)
                    tvHvsPrevValue.text = StringBuilder().append(task.c_hvs_night_prev_value)
                    tvHvsCurrentValue.text = StringBuilder().append(task.c_hvs_night_current_value)
                    idHvsCurrentRb = R.id.id_card_hvs_night
                    etHvsValue.setText(strHvsNight)
                } else if (checkedId == R.id.id_card_hvs_half_peak) {
                    tvHvsPrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_hvs_half_peak_prev_date)
                    tvHvsCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_hvs_half_peak_current_date)
                    tvHvsPrevValue.text = StringBuilder().append(task.c_hvs_half_peak_prev_value)
                    tvHvsCurrentValue.text = StringBuilder().append(task.c_hvs_half_peak_current_value)
                    idHvsCurrentRb = R.id.id_card_hvs_half_peak
                    etHvsValue.setText(strHvsHalfPeak)
                }
            }
        }
        rgEleGroup.setOnCheckedChangeListener { _, checkedId ->
            if (idEleCurrentRb == R.id.id_card_ele_night) {
                strEleNight = etEleValue.text.toString()
                if (checkedId == R.id.id_card_ele_half_peak) {
                    tvElePrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_ele_half_peak_prev_date)
                    tvEleCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_ele_half_peak_current_date)
                    tvElePrevValue.text = StringBuilder().append(task.c_ele_half_peak_prev_value)
                    tvEleCurrentValue.text = StringBuilder().append(task.c_ele_half_peak_current_value)
                    idEleCurrentRb = R.id.id_card_ele_half_peak
                    etEleValue.setText(strEleHalfPeak)
                } else if (checkedId == R.id.id_card_ele_peak) {
                    tvElePrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_ele_peak_prev_date)
                    tvEleCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_ele_peak_current_date)
                    tvElePrevValue.text = StringBuilder().append(task.c_ele_peak_prev_value)
                    tvEleCurrentValue.text = StringBuilder().append(task.c_ele_peak_current_value)
                    idEleCurrentRb = R.id.id_card_ele_peak
                    etEleValue.setText(strElePeak)
                }
            } else if (idEleCurrentRb == R.id.id_card_ele_half_peak) {
                strEleHalfPeak = etEleValue.text.toString()
                if (checkedId == R.id.id_card_ele_night) {
                    tvElePrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_ele_night_prev_date)
                    tvEleCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_ele_night_current_date)
                    tvElePrevValue.text = StringBuilder().append(task.c_ele_night_prev_value)
                    tvEleCurrentValue.text = StringBuilder().append(task.c_ele_night_current_value)
                    idEleCurrentRb = R.id.id_card_ele_night
                    etEleValue.setText(strEleNight)
                } else if (checkedId == R.id.id_card_ele_peak) {
                    tvElePrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_ele_peak_prev_date)
                    tvEleCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_ele_peak_current_date)
                    tvElePrevValue.text = StringBuilder().append(task.c_ele_peak_prev_value)
                    tvEleCurrentValue.text = StringBuilder().append(task.c_ele_peak_current_value)
                    idEleCurrentRb = R.id.id_card_ele_peak
                    etEleValue.setText(strElePeak)
                }
            } else if (idEleCurrentRb == R.id.id_card_ele_peak) {
                strElePeak = etEleValue.text.toString()
                if (checkedId == R.id.id_card_ele_night) {
                    tvElePrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_ele_night_prev_date)
                    tvEleCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_ele_night_current_date)
                    tvElePrevValue.text = StringBuilder().append(task.c_ele_night_prev_value)
                    tvEleCurrentValue.text = StringBuilder().append(task.c_ele_night_current_value)
                    idEleCurrentRb = R.id.id_card_ele_night
                    etEleValue.setText(strEleNight)
                } else if (checkedId == R.id.id_card_ele_half_peak) {
                    tvElePrevDate.text = StringBuilder().append(getString(R.string.prev)," ").append(task.c_ele_half_peak_prev_date)
                    tvEleCurrentDate.text = StringBuilder().append(getString(R.string.current)," ").append(task.c_ele_half_peak_current_date)
                    tvElePrevValue.text = StringBuilder().append(task.c_ele_half_peak_prev_value)
                    tvEleCurrentValue.text = StringBuilder().append(task.c_ele_half_peak_current_value)
                    idEleCurrentRb = R.id.id_card_ele_half_peak
                    etEleValue.setText(strEleHalfPeak)
                }
            }
        }

        findViewById<ImageView>(R.id.settings2).setOnClickListener{
            startActivity(Intent(this, SettingsActivity::class.java))
        }
        
        bSave.setOnClickListener{
            if (check(strGvsPeak, strGvsHalfPeak, strGvsNight, etGvsValue, rgGvsGroup, R.id.id_card_gvs_peak, R.id.id_card_gvs_half_peak, R.id.id_card_gvs_night) and
                    check(strHvsPeak, strHvsHalfPeak, strHvsNight, etHvsValue, rgHvsGroup, R.id.id_card_hvs_peak, R.id.id_card_hvs_half_peak, R.id.id_card_hvs_night) and
                    check(strElePeak, strEleHalfPeak, strEleNight, etEleValue, rgEleGroup, R.id.id_card_ele_peak, R.id.id_card_ele_half_peak, R.id.id_card_ele_night)) {

                updateGvs(task, strGvsPeak, strGvsHalfPeak, strGvsNight, etGvsValue, rgGvsGroup, R.id.id_card_gvs_peak, R.id.id_card_gvs_half_peak, R.id.id_card_gvs_night)
                updateHvs(task, strHvsPeak, strHvsHalfPeak, strHvsNight, etHvsValue, rgHvsGroup, R.id.id_card_hvs_peak, R.id.id_card_hvs_half_peak, R.id.id_card_hvs_night)
                updateEle(task, strElePeak, strEleHalfPeak, strEleNight, etEleValue, rgEleGroup, R.id.id_card_ele_peak, R.id.id_card_ele_half_peak, R.id.id_card_ele_night)
                task.update()
                Toast.makeText(this, "Показания записаны", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, "Ошибка в показаниях!\nВведите адекватное значение!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun dropperAction() {
        if (bInfoOpen) {
            llNumbers.visibility = View.GONE
            llFio.visibility = View.GONE
            llAddress.visibility = View.GONE
            tvTitle.text = task.task_id.toString()
            tvValue.text = strFio
            llDropper.visibility = View.VISIBLE
        } else {
            llNumbers.visibility = View.VISIBLE
            llFio.visibility = View.VISIBLE
            llAddress.visibility = View.VISIBLE
            tvTitle.setText(R.string.LS)
            tvValue.text = task.c_client_ls
            llDropper.visibility = View.GONE
        }
        bInfoOpen = !bInfoOpen
    }
}