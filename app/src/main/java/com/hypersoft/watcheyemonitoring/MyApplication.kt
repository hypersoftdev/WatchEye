package com.hypersoft.watcheyemonitoring

import android.app.Application
import com.hypersoft.watcheye.monitor_watcher.WatchEyeMonitorBuilder

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize and start Watch Eye with default settings
        WatchEyeMonitorBuilder(this).build().start()


        // Initialize and start Watch Eye Monitor Builder with custom settings
        //val firebaseCrashlytics = FirebaseCrashlytics.getInstance()
        WatchEyeMonitorBuilder(this).setTimeTicker(200L) // Set ticker interval (1-500ms)
            .setTimeThreshold(3000L) // Set ANR threshold (1000-4500ms)
            .setErrorTitle("Error Title") // Set custom crash dialog title
            .setErrorMessage("Error Message") // Set custom crash dialog message
             //.setFirebaseCrashLytics(firebaseCrashlytics) // Integrate with Firebase Crashlytics
            .build().start()


    }
}