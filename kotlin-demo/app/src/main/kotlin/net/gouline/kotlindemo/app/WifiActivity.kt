package net.gouline.kotlindemo.app

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
import net.gouline.kotlindemo.model.WifiStation
import android.app.Fragment

/**
 * Root activity for Wi-Fi list and details.
 *
 * @author Mike Gouline
 */
open class WifiActivity() : Activity() {
    private var listFragment: WifiListFragment? = null
    private var detailFragment: WifiDetailFragment? = null

    private var listFragmentVisible: Boolean = false

    private var wifiManager: WifiManager? = null
    private val wifiReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val results = wifiManager?.getScanResults()
            if (listFragmentVisible && results != null) {
                listFragment?.updateItems(results)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi)
        setTitle(R.string.title_wifi)

        transitionToList()

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
            refreshList()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super<Activity>.onResume()
        registerReceiver(wifiReceiver, IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
    }

    fun onResumeFragment(fragment: Fragment) {
        listFragmentVisible = false

        if (fragment == listFragment) {
            listFragmentVisible = true

            refreshList()
        }
    }

    override fun onPause() {
        unregisterReceiver(wifiReceiver)
        super<Activity>.onPause()
    }

    fun transition(fragment: Fragment, add: Boolean = false) {
        val transaction = getFragmentManager().beginTransaction()
        transaction.replace(R.id.layout_frame, fragment)
        if (add) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    fun transitionToList() {
        listFragment = WifiListFragment.newInstance()
        transition(listFragment!!)
    }

    fun transitionToDetail(item: WifiStation?) {
        detailFragment = WifiDetailFragment.newInstance()
        transition(detailFragment!!, add = true)
    }

    /**
     * Refreshes list.
     */
    private fun refreshList() {
        listFragment?.clearItems()
        wifiManager?.startScan()
    }
}
