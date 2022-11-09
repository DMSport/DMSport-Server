package com.project.dmsport.global.util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomUtil {

    public static final Random RANDOM = new Random();

    public String createRandomCode() {
        return String.format("%06d", RANDOM.nextInt(1000000) % 1000000);
    }

    public int createRandomNumber(int n) {
        return RANDOM.nextInt(n);
    }
}