package com.sample.watcheye_anrcrashmonitoring.monitor_watcher

import com.sample.watcheye_anrcrashmonitoring.anr_watcher.AnrMonitor
import com.sample.watcheye_anrcrashmonitoring.crash_watcher.CrashMonitor


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