package com.sample.watcheye_anrcrashmonitoring.monitor_watcher

import com.sample.watcheye_anrcrashmonitoring.anr_watcher.AnrMonitor
import com.sample.watcheye_anrcrashmonitoring.crash_watcher.CrashMonitor

interface WatchEyeMonitor{
    var anrMonitor: AnrMonitor
    var crashMonitor: CrashMonitor
    fun start()
    fun stop()
}