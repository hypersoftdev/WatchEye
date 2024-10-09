package com.example.watcheye.exception_handler


import android.content.Context
import android.content.Intent
import com.example.watcheye.util.Konstants.EXTRA_MESSAGE
import com.example.watcheye.util.Konstants.EXTRA_TITLE
import com.example.watcheye.MainActivity
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlin.system.exitProcess

class CustomExceptionHandlerImpl(
    override val context: Context,
    override val mFirebaseCrashlytics: FirebaseCrashlytics?,
    override val title: String,
    override val msg: String
) : CustomExceptionHandler {
    override fun uncaughtException(t: Thread, e: Throwable) {
        mFirebaseCrashlytics?.recordException(e)
        launchReportActivity(context,title,msg)
        exitProcess(0)
    }

    fun launchReportActivity(context: Context, title:String, msg:String){
        context.startActivity(
            Intent(context, MainActivity::class.java).apply {
                putExtra(EXTRA_TITLE,title)
                putExtra(EXTRA_MESSAGE,msg)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
        )
    }
}