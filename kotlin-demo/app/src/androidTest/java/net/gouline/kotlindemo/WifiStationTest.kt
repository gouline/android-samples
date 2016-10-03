package net.gouline.kotlindemo

import android.test.AndroidTestCase
import junit.framework.Assert
import net.gouline.kotlindemo.model.WifiStation

/**
 * Test case for {@link net.gouline.kotlindemo.model.WifiStation}.
 */
class WifiStationTest() : AndroidTestCase() {

    fun testModel() {
        val station = WifiStation("ssid", "bssid", 5000, 5)
        Assert.assertEquals("ssid", station.ssid)
        Assert.assertEquals("bssid", station.bssid)
        Assert.assertEquals(Integer.valueOf(5000), station.frequency)
        Assert.assertEquals(Integer.valueOf(5), station.level)
    }
}
