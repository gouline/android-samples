package net.gouline.kotlindemo.app

import android.app.ListFragment
import android.content.Context
import android.net.wifi.ScanResult
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_wifi_list.*
import kotlinx.android.synthetic.main.list_item_wifi.view.*
import net.gouline.kotlindemo.R
import net.gouline.kotlindemo.model.WifiStation

/**
 * Fragment for listing Wi-Fi base stations.
 */
open class WifiListFragment() : ListFragment() {

    companion object {
        fun newInstance() = WifiListFragment()
    }

    private var emptyView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_wifi_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emptyView = progress

        listAdapter = WifiListAdapter(activity)
        listView.emptyView = emptyView
    }

    override fun onResume() {
        super.onResume()

        val activity = this.activity
        if (activity is WifiActivity) {
            activity.onResumeFragment(this)
        }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        val activity = this.activity
        if (activity is WifiActivity) {
            val item = l.getItemAtPosition(position) as WifiStation
            activity.transitionToDetail(item)
        }
    }

    /**
     * Updates adapter and calls notify.
     *
     * @param stations List of scan results.
     */
    fun updateItems(stations: List<ScanResult>? = null) {
        val listAdapter = this.listAdapter
        if (listAdapter is WifiListAdapter) {
            listAdapter.clear()
            if (stations != null) {
                emptyView?.visibility = if (stations.size > 0) View.VISIBLE else View.GONE
                listAdapter.addAll(WifiStation.newList(stations))
            }
            listAdapter.notifyDataSetChanged()
        }
    }

    /**
     * Clears adapter items and calls notify.
     */
    fun clearItems() = updateItems()

    /**
     * Array adapter for stations.
     */
    class WifiListAdapter(context: Context) : ArrayAdapter<WifiStation>(context, 0) {
        private val inflater: LayoutInflater = LayoutInflater.from(context)

        @Suppress("IfThenToElvis")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val item = getItem(position)
            val view = if (convertView != null) {
                convertView
            } else {
                inflater.inflate(R.layout.list_item_wifi, parent, false)
            }

            view.txt_ssid.text = item.ssid
            view.txt_bssid.text = item.bssid
            view.txt_frequency.text = context.getString(R.string.station_frequency, item.frequency)
            view.txt_level.text = context.getString(R.string.station_level, item.level)

            return view
        }
    }
}
