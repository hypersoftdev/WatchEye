package com.sample.watcheye_anrcrashmonitoring.anr_watcher

internal class AnrMonitorException(title:String, stacktrace:Array<StackTraceElement>):Throwable(title) {
    init {
        stackTrace = stacktrace
    }
}