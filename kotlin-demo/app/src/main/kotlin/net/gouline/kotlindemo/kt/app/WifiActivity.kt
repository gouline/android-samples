package net.gouline.kotlindemo.kt.app

import android.app.Activity
import android.os.Bundle
import net.gouline.kotlindemo.R

/**
 * Root activity for Wi-Fi list and details.
 *
 * @author Mike Gouline
 */
open class WifiActivity() : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi)

        val fragment = WifiListFragment.newInstance()

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_frame, fragment)
                .commit()
    }
}