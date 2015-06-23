package net.gouline.jacoco.util;

/**
 * Supposedly useful utilities.
 * <p/>
 * Created by mgouline on 24/06/15.
 */
public final class UsefulUtils {

    private UsefulUtils() {
    }

    /**
     * Calculates the sum of integers. Wow, much useful!
     */
    public static int sum(int... nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }
}
