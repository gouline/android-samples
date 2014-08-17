package net.gouline.kotlindemo.kt.model

import java.io.Serializable
import android.net.wifi.ScanResult
import java.util.ArrayList

/**
 * Data container for a Wi-Fi base station.
 *
 * @author Mike Gouline
 */
data class WifiStation(
        val ssid: String?,
        val bssid: String?,
        val frequency: Int,
        val level: Int): Serializable {
    class object {
        fun newInstance(sr: ScanResult): WifiStation {
            return WifiStation(
                    ssid = sr.SSID,
                    bssid = sr.BSSID,
                    frequency = sr.frequency,
                    level = sr.level
            )
        }

        /**
         * Creates a new list of Wi-Fi stations from a list of scan results.
         *
         * @param srs List of scan results.
         */
        fun newList(srs: List<ScanResult>): List<WifiStation> {
            val stations = ArrayList<WifiStation>()
            for (sr in srs) {
                stations.add(newInstance(sr))
            }
            return stations
        }
    }
}