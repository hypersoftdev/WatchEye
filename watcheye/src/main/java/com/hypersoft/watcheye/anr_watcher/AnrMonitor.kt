package com.hypersoft.watcheye.anr_watcher

interface AnrMonitor {
    var mDuration:Long
    var mTicker:Long
    var mTester:Int
    var mThreshold:Long
    fun handleAnr(stack:Array<StackTraceElement>,duration: Long)
    fun startMonitor()
    fun stopMonitor()
}