package ru.hutoroff.hermes.test.utils;

import java.util.Random;

/**
 * Generates random data for test needs
 * Created by hutoroff on 28.08.16.
 */
public class TestRandomizer {
    private static Double generateRandomDouble() {
        Random rand = new Random();
        return rand.nextDouble();
    }

    public static Double generateRandomDouble(final Double min, final Double max) {
        double dMin = min == null ? Double.MIN_VALUE : min;
        double dMax = max == null ? Double.MAX_VALUE : max;

        return dMin + (generateRandomDouble() * (dMax - dMin));
    }

    private static Integer generateRandomInteger() {
        Random rand = new Random();
        return rand.nextInt();
    }

    public static Integer generateRandomInteger(Integer min, Integer max) {
        int iMin = min == null ? Integer.MIN_VALUE : min;
        int iMax = max == null ? Integer.MAX_VALUE : max;

        return iMin + (generateRandomInteger() * (iMax - iMin));
    }
}
