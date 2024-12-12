package com.hypersoft.watcheye.monitor_watcher

import com.hypersoft.watcheye.anr_watcher.AnrMonitor
import com.hypersoft.watcheye.crash_watcher.CrashMonitor


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