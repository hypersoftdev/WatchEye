package com.sample.watcheye_anrcrashmonitoring.anr_watcher



internal object AnrMonitorBuilder {
    val TICKER_DEFAULT = 100L
    val THRESHOLD_DEFAULT = 4000L

    private var mThreshold: Long = THRESHOLD_DEFAULT
    private var mTicker: Long = TICKER_DEFAULT

    fun setTimeTicker(ticker: Long): AnrMonitorBuilder {
        mTicker = ticker.coerceIn(1,500)
        return this
    }

    fun setTimeThreshold(threshold: Long): AnrMonitorBuilder {
        mThreshold = threshold.coerceIn(1000, 4500)
        return this
    }

    fun build(): AnrMonitor = AnrMonitorImpl(mTicker, mThreshold)

}