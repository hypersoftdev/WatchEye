package com.hypersoft.watcheye.monitor_watcher

import com.hypersoft.watcheye.anr_watcher.AnrMonitor
import com.hypersoft.watcheye.crash_watcher.CrashMonitor

interface WatchEyeMonitor{
    var anrMonitor: AnrMonitor
    var crashMonitor: CrashMonitor
    fun start()
    fun stop()
}