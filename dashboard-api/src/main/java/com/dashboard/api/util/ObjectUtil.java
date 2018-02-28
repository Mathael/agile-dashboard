package com.dashboard.api.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author LEBOC Philippe
 */
@Slf4j
public final class ObjectUtil {

    private ObjectUtil() {
        // Never instanciate an Util class
    }

    /**
     * Generate random Integer
     * @param min minimum value (inclusive)
     * @param max maximum value (inclusive)
     * @return a random integer in the give range
     */
    public static int random(int min, int max) {
        final Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Generate random Long
     * @param min minimum value (inclusive)
     * @param max maximum value (inclusive)
     * @return a random long in the give range
     */
    public static long random(long min, long max) {
        final Random random = new Random();
        return random.nextLong() * (max - min) + min;
    }

    /**
     * Generate random float
     * @param min minimum value (inclusive)
     * @param max maximum value (inclusive)
     * @return a random float in the give range
     */
    public static float random(float min, float max) {
        final Random random = new Random();
        return random.nextFloat() * (max - min) + min;
    }
}
