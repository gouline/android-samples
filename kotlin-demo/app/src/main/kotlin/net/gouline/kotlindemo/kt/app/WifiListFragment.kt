package net.gouline.kotlindemo.kt.app

import android.app.ListFragment
import android.net.wifi.ScanResult
import android.os.Bundle
import android.widget.ArrayAdapter
import net.gouline.kotlindemo.kt.model.WifiStation
import android.view.View
import android.view.ViewGroup
import android.content.Context
import android.view.LayoutInflater
import net.gouline.kotlindemo.R
import android.widget.TextView

/**
 * Fragment for listing Wi-Fi base stations.
 *
 * @author Mike Gouline
 */
open class WifiListFragment() : ListFragment() {
    private var emptyView: View? = null

    class object {
        fun newInstance(): WifiListFragment {
            return WifiListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_wifi_list, container, false)
        emptyView = view?.findViewById(R.id.progress) as View
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super<ListFragment>.onViewCreated(view, savedInstanceState)
        setListAdapter(WifiListAdapter(getActivity()!!))
        getListView()?.setEmptyView(emptyView)
    }

    /**
     * Updates adapter and calls notify.
     *
     * @param stations List of scan results.
     */
    fun updateItems(stations: List<ScanResult>? = null) {
        val adapter = getListAdapter() as WifiListAdapter
        adapter.clear()
        if (stations != null) {
            val emptyVisible: Int = if (stations.size() > 0) View.VISIBLE else View.GONE
            emptyView?.setVisibility(emptyVisible)
            adapter.addAll(WifiStation.newList(stations))
        }
        adapter.notifyDataSetChanged()
    }

    /**
     * Clears adapter items and calls notify.
     */
    fun clearItems() {
        updateItems()
    }

    /**
     * Array adapter for stations.
     */
    class WifiListAdapter(context: Context) : ArrayAdapter<WifiStation>(context, 0) {
        val inflater = LayoutInflater.from(context)

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            val item = getItem(position)
            val view = convertView ?: inflater.inflate(R.layout.list_item_wifi, parent, false)

            val ssidTextView = view?.findViewById(R.id.txt_ssid) as TextView
            ssidTextView.setText(item?.ssid)

            val bssidTextView = view?.findViewById(R.id.txt_bssid) as TextView
            bssidTextView.setText(item?.bssid)

            val frequencyTextView = view?.findViewById(R.id.txt_frequency) as TextView
            frequencyTextView.setText(getContext()?.getString(R.string.station_frequency, item?.frequency))

            val levelTextView = view?.findViewById(R.id.txt_level) as TextView
            levelTextView.setText(getContext()?.getString(R.string.station_level, item?.level))

            return view
        }
    }
}
