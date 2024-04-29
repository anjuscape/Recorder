package com.anjali.recorder

import android.app.Application
import com.anjali.recorder.util.FileRepository
import com.anjali.recorder.util.FileRepositoryImpl
import com.anjali.recorder.util.NotificationHelper
import com.anjali.recorder.util.Preferences
import com.anjali.recorder.util.ShortcutHelper

class App : Application() {
    val fileRepository: FileRepository by lazy {
        FileRepositoryImpl(this)
    }
    override fun onCreate() {
        super.onCreate()
        Preferences.init(this)
        NotificationHelper.buildNotificationChannels(this)
        ShortcutHelper.createShortcuts(this)
    }
}
