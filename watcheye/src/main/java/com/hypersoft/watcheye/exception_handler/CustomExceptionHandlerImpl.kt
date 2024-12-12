package com.hypersoft.watcheye.exception_handler


import android.content.Context
import android.content.Intent
import com.hypersoft.watcheye.ErrorActivity
import com.hypersoft.watcheye.util.Konstants.EXTRA_MESSAGE
import com.hypersoft.watcheye.util.Konstants.EXTRA_TITLE

import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlin.system.exitProcess

class CustomExceptionHandlerImpl(
    override val context: Context, override val mFirebaseCrashlytics: FirebaseCrashlytics?, override val title: String, override val msg: String
) : CustomExceptionHandler {
    override fun uncaughtException(t: Thread, e: Throwable) {
        mFirebaseCrashlytics?.recordException(e)
        launchReportActivity(context, title, msg)
        exitProcess(0)
    }

    fun launchReportActivity(context: Context, title: String, msg: String) {
        context.startActivity(Intent(context, ErrorActivity::class.java).apply {
            putExtra(EXTRA_TITLE, title)
            putExtra(EXTRA_MESSAGE, msg)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        })
    }
}