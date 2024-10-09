package com.example.watcheye.monitor_watcher

import com.example.watcheye.anr_watcher.AnrMonitor
import com.example.watcheye.crash_watcher.CrashMonitor


internal class WatchEyeMonitorImpl(
    override var anrMonitor: AnrMonitor,
    override var crashMonitor: CrashMonitor
) : WatchEyeMonitor {
    override fun start() {
        crashMonitor.startMonitor()
        anrMonitor.startMonitor()
    }

    override fun stop() {
        crashMonitor.stopMonitor()
        anrMonitor.stopMonitor()
    }
}