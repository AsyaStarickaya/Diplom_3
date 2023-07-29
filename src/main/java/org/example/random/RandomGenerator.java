package org.example.random;

import org.apache.commons.lang3.RandomStringUtils;


public class RandomGenerator {
    public static String getRandom() {
        return RandomStringUtils.randomAlphabetic(6);
    }
}
