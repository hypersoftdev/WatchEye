package com.hypersoft.watcheye.anr_watcher

internal class AnrMonitorException(title:String, stacktrace:Array<StackTraceElement>):Throwable(title) {
    init {
        stackTrace = stacktrace
    }
}