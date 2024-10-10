package com.hypersoft.watcheye.anr_watcher

import android.os.Handler
import android.os.Looper
import android.util.Log

internal class AnrMonitorImpl(
    override var mTicker: Long,
    override var mThreshold: Long

) : AnrMonitor {
    override var mDuration: Long = 0
    override var mTester: Int = 0
    private var mThread: Thread? = null
    private var running = false
    private var mHandler: Handler = Handler(Looper.getMainLooper())

    override fun startMonitor() {
        running = true
        mThread = Thread {
            while (!Thread.currentThread().isInterrupted) {
                mDuration += mTicker
                mHandler.post{
                    mTester = 0
                    mDuration = 0
                }

                if(mDuration >= mThreshold && mTester == 1){
                    val stack = Looper.getMainLooper().thread.stackTrace
                    handleAnr(stack, mDuration)
                }
                try {
                    Thread.sleep(mTicker)
                } catch (e: InterruptedException) {
                    Thread.currentThread().interrupt()
                    return@Thread
                }

                if(mTester == 0){
                    mTester = 1
                }
            }
        }
        mThread?.start()
    }

    override fun stopMonitor() {
        mThread?.interrupt()
        mThread = null
    }

    override fun handleAnr(stack: Array<StackTraceElement>,duration:Long) {
        val method = stack.firstOrNull()?.methodName
        val title = "Method:$method is blocking Main Thread for atleast $duration"
        throw AnrMonitorException(title,stack)
    }

}