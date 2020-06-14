package com.qavan.voiceinspectorgui.utils

import android.content.Context
import android.content.res.Configuration

class ThemeManager {
    fun getCurrentTheme(context: Context): Byte {
        var returnable:Byte = -1
        when((context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> returnable = 1
            Configuration.UI_MODE_NIGHT_NO -> returnable = 0
            Configuration.UI_MODE_NIGHT_UNDEFINED -> returnable = -1
        }
        return returnable
    }
}