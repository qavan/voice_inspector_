package com.qavan.voiceinspectorgui

import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.qavan.voiceinspectorgui.utils.Settings

class SettingsActivity:AppCompatActivity() {
    private val theme = "DARK"
    private val settings = "settings"
    private lateinit var mThemeSwitch: Switch
    private lateinit var mSettings: Settings.GlobalSettings

    override fun onCreate(savedInstanceState: Bundle?) {
        mSettings = Settings.GlobalSettings(this, settings)
        if (mSettings.isYes(theme)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        mThemeSwitch = findViewById(R.id.idSwitchTheme)
        mThemeSwitch.isChecked = mSettings.isYes(theme)
        mThemeSwitch.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
            run {
                if (b) mSettings.add(theme,"yes")
                else mSettings.add(theme, "no")
            }
        }

        findViewById<Button>(R.id.idButtonSave).setOnClickListener{
            run {
                mSettings.saveChanges()
                recreate()
            }
        }

        mSettings.initEditor()
    }
}