package com.sample.watcheye_anrcrashmonitoring.crash_watcher

import android.content.Context
import com.sample.watcheye_anrcrashmonitoring.exception_handler.CustomExceptionHandler
import com.sample.watcheye_anrcrashmonitoring.exception_handler.CustomExceptionHandlerImpl
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.lang.Thread.UncaughtExceptionHandler

internal class CrashMonitorImpl(
    override var mContext: Context,
    override var mCrashLytics: FirebaseCrashlytics?,
    override var mTitle: String,
    override var mMessage: String
) : CrashMonitor {
    private var mDefaultHandler:UncaughtExceptionHandler? = null
    override fun startMonitor() {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        val exceptionHandler: CustomExceptionHandler = CustomExceptionHandlerImpl(mContext,mCrashLytics,mTitle,mMessage)
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler)
    }

    override fun stopMonitor() {
        Thread.setDefaultUncaughtExceptionHandler(mDefaultHandler)
        mDefaultHandler = null
    }

}