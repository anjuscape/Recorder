package com.anjali.recorder.enums

import com.anjali.recorder.util.Preferences

enum class ThemeMode {
    SYSTEM,
    LIGHT,
    DARK,
    AMOLED
    ;

    companion object {
        fun getCurrent() = valueOf(Preferences.getString(Preferences.themeModeKey, SYSTEM.name))
    }
}
