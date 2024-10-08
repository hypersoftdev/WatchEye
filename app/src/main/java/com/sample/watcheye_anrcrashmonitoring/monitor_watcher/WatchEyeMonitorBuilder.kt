package com.sample.watcheye_anrcrashmonitoring.monitor_watcher
import android.content.Context
import com.sample.watcheye_anrcrashmonitoring.anr_watcher.AnrMonitorBuilder
import com.sample.watcheye_anrcrashmonitoring.anr_watcher.AnrMonitorBuilder.THRESHOLD_DEFAULT
import com.sample.watcheye_anrcrashmonitoring.anr_watcher.AnrMonitorBuilder.TICKER_DEFAULT
import com.sample.watcheye_anrcrashmonitoring.crash_watcher.CrashMonitorBuilder
import com.google.firebase.crashlytics.FirebaseCrashlytics

/**
 * Builder class for creating an instance of [WatchEyeMonitor].
 *
 * @property context The application context.
 */


class WatchEyeMonitorBuilder(private val context: Context) {

    // ANR Monitor Params
    private var mTicker: Long = TICKER_DEFAULT
    private var mThreshold: Long = THRESHOLD_DEFAULT

    // Crash Monitor Params
    private var mTitle: String = "Application Error"
    private var mMessage: String = "An unexpected error occurred. Please restart the app."
    private var mFirebaseCrashlytics: FirebaseCrashlytics? = null

    /**
     * Sets the ticker interval for the ANR monitor.
     *
     * @param ticker The interval in milliseconds. Valid values are between 1 and 500.
     * @return The current instance of [WatchEyeMonitorBuilder].
     */
    fun setTimeTicker(ticker: Long): WatchEyeMonitorBuilder {
        this.mTicker = ticker
        return this
    }

    /**
     * Sets the threshold for detecting ANRs.
     *
     * @param threshold The threshold in milliseconds. Valid values are between 1000 and 4500.
     * @return The current instance of [WatchEyeMonitorBuilder].
     */
    fun setTimeThreshold(threshold: Long): WatchEyeMonitorBuilder {
        this.mThreshold = threshold
        return this
    }

    /**
     * Sets the title for crash dialogs.
     *
     * @param title The title to be displayed.
     * @return The current instance of [WatchEyeMonitorBuilder].
     */
    fun setErrorTitle(title: String): WatchEyeMonitorBuilder {
        this.mTitle = title
        return this
    }

    /**
     * Sets the message for crash dialogs.
     *
     * @param message The message to be displayed.
     * @return The current instance of [WatchEyeMonitorBuilder].
     */
    fun setErrorMessage(message: String): WatchEyeMonitorBuilder {
        this.mMessage = message
        return this
    }

    /**
     * Sets the Firebase Crashlytics instance for crash reporting.
     *
     * @param firebaseCrashlytics The FirebaseCrashlytics instance.
     * @return The current instance of [WatchEyeMonitorBuilder].
     */
    fun setFirebaseCrashLytics(firebaseCrashlytics: FirebaseCrashlytics): WatchEyeMonitorBuilder {
        this.mFirebaseCrashlytics = firebaseCrashlytics
        return this
    }

    /**
     * Builds and returns an instance of [WatchEyeMonitor].
     *
     * @return A new instance of [WatchEyeMonitor].
     */
    fun build(): WatchEyeMonitor {
        return WatchEyeMonitorImpl(
            AnrMonitorBuilder
                .setTimeTicker(mTicker)
                .setTimeThreshold(mThreshold)
                .build(),
            CrashMonitorBuilder(context)
                .setErrorTitle(mTitle)
                .setErrorTitle(mMessage)
                .setFirebaseCrashlytics(mFirebaseCrashlytics)
                .build()
        )
    }
}