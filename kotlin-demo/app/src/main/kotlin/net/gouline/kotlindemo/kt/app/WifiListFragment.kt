package net.gouline.kotlindemo.kt.app

import android.app.ListFragment

/**
 * Fragment for listing Wi-Fi base stations.
 *
 * @author Mike Gouline
 */
open class WifiListFragment() : ListFragment() {
    class object {
        fun newInstance(): WifiListFragment {
            return WifiListFragment()
        }
    }
}