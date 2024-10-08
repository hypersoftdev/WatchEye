package com.example.watcheye.crash_watcher

import android.content.Context
import com.google.firebase.crashlytics.FirebaseCrashlytics


interface CrashMonitor {
    var mContext:Context
    var mCrashLytics: FirebaseCrashlytics?
    var mTitle:String
    var mMessage:String
    fun startMonitor()
    fun stopMonitor()
}