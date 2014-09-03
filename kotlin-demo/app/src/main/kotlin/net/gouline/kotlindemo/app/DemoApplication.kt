package net.gouline.kotlindemo.app

import android.app.Application
import android.util.Log
import net.gouline.kotlindemo.BuildTypeConfig

/**
 * Custom application implementation.
 *
 * @author Mike Gouline
 */
class DemoApplication() : Application() {
    val TAG = "DemoApplication"

    override fun onCreate() {
        super<Application>.onCreate()

        //Log.d(TAG, BuildTypeConfig.LOG_MESSAGE)
    }
}
