package net.gouline.kotlindemo.kt.app

import android.app.Activity
import android.os.Bundle
import net.gouline.kotlindemo.R
import android.net.wifi.WifiManager
import android.content.Context
import android.widget.Toast
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.content.Intent
import android.view.Menu
import android.view.MenuItem

/**
 * Root activity for Wi-Fi list and details.
 *
 * @author Mike Gouline
 */
open class WifiActivity() : Activity() {
    private var wifiManager: WifiManager? = null

    private var listFragment: WifiListFragment? = null

    private val wifiReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val results = wifiManager?.getScanResults()
            if (results != null) {
                listFragment?.updateItems(results)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi)
        setTitle(R.string.title_wifi)

        listFragment = WifiListFragment.newInstance()

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_frame, listFragment!!)
                .commit()

        wifiManager = getSystemService(Context.WIFI_SERVICE) as WifiManager
        if (wifiManager?.isWifiEnabled() == false) {
            Toast.makeText(this, R.string.prompt_enabling_wifi, Toast.LENGTH_SHORT).show()
            wifiManager?.setWifiEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.wifi, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.getItemId()
        if (id == R.id.action_refresh) {
            refresh()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super<Activity>.onResume()

        registerReceiver(wifiReceiver, IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
        refresh()
    }

    override fun onPause() {
        unregisterReceiver(wifiReceiver)

        super<Activity>.onPause()
    }

    fun refresh() {
        wifiManager?.startScan()
    }
}
