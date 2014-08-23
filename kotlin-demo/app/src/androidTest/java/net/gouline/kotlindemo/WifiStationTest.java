package net.gouline.kotlindemo;

import android.test.AndroidTestCase;

import net.gouline.kotlindemo.model.WifiStation;

/**
 * Test case for {@link net.gouline.kotlindemo.model.WifiStation}.
 *
 * @author Mike Gouline
 */
public class WifiStationTest extends AndroidTestCase {
    public void testModel() {
        WifiStation station = new WifiStation("ssid", "bssid", 5000, 5);
        assertEquals("ssid", station.getSsid());
        assertEquals("bssid", station.getBssid());
        assertEquals(Integer.valueOf(5000), station.getFrequency());
        assertEquals(Integer.valueOf(5), station.getLevel());
    }
}
