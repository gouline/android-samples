package net.gouline.kotlindemo

import android.test.AndroidTestCase

import net.gouline.kotlindemo.model.WifiStation
import junit.framework.Assert

/**
 * Test case for {@link net.gouline.kotlindemo.model.WifiStation}.
 *
 * @author Mike Gouline
 */
public class WifiStationTest() : AndroidTestCase() {
    public fun testModel() {
        val station = WifiStation("ssid", "bssid", 5000, 5)
        Assert.assertEquals("ssid", station.ssid)
        Assert.assertEquals("bssid", station.bssid)
        Assert.assertEquals(Integer.valueOf(5000), station.frequency)
        Assert.assertEquals(Integer.valueOf(5), station.level)
    }
}
