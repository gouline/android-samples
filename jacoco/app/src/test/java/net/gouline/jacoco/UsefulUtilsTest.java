package net.gouline.jacoco;

import android.os.Build;

import net.gouline.jacoco.util.UsefulUtils;

import org.junit.Test;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * Test case for {@link UsefulUtils}.
 * <p/>
 * Created by mgouline on 24/05/15.
 */
@Config(sdk = Build.VERSION_CODES.KITKAT)
public class UsefulUtilsTest {

    @Test
    public void testSum_standard() {
        assertEquals(6, UsefulUtils.sum(1, 2, 3));
    }

    @Test
    public void testSum_empty() {
        assertEquals(0, UsefulUtils.sum());
    }
}