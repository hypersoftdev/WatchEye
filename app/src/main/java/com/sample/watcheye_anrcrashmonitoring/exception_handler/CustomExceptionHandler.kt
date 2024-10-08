package com.sample.watcheye_anrcrashmonitoring.exception_handler

import android.content.Context
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.lang.Thread.UncaughtExceptionHandler

interface CustomExceptionHandler : UncaughtExceptionHandler {
    val context: Context
    val mFirebaseCrashlytics: FirebaseCrashlytics?
    val title: String
    val msg: String
}