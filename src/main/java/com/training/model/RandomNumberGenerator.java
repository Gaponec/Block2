package com.training.model;


import java.util.concurrent.ThreadLocalRandom;

/**
 * Generator of random integer values
 *
 * @author Liakhovetskyi Bohdan
 * @since 1.7
 */
public class RandomNumberGenerator {

    /* Maximum value that have to be got from rand function */
    public static final int RAND_MAX = 100;

    /**
     * Generates random integer value from 0 to RAND_MAX value
     *
     * @return random integer value
     */
    public int rand() {
        return ThreadLocalRandom.current().nextInt(RAND_MAX) + 1;
    }

    /**
     * Generates random integer value that in range of input parameters
     *
     * @param min minimum value of random value
     * @param max maximum value of random value
     * @return random integer value
     */
    public int rand(int min, int max) {
        if(min == max) {
            return min;
        }
        return ThreadLocalRandom.current().nextInt(min, max) + 1;
    }
}
