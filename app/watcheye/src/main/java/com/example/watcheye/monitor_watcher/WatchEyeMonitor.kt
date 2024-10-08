package com.example.watcheye.monitor_watcher

import com.example.watcheye.anr_watcher.AnrMonitor
import com.example.watcheye.crash_watcher.CrashMonitor

interface WatchEyeMonitor{
    var anrMonitor: AnrMonitor
    var crashMonitor: CrashMonitor
    fun start()
    fun stop()
}