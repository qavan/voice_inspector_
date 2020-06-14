package com.qavan.voiceinspectorgui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.qavan.voiceinspectorgui.utils.Settings
import kotlinx.coroutines.*

class SplashScreenActivity:AppCompatActivity() {
    private val theme:String = "DARK"
    private lateinit var mSettings:Settings.GlobalSettings
    private val splashScreenCoroutine = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        mSettings = Settings.GlobalSettings(this, "settings")
        if (mSettings.isYes(theme)) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        if (mSettings.get(theme) == "none") {
            mSettings.initEditor()
            mSettings.add(theme,"no")
            mSettings.saveChanges()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splashScreenCoroutine.launch {
            delay(1500)
            startActivity(Intent(this@SplashScreenActivity,RouteActivity::class.java))
            finish()
        }
    }

    override fun onPause() {
        splashScreenCoroutine.cancel()
        super.onPause()
    }
}