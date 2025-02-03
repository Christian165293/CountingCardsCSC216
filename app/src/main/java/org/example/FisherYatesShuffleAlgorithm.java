package org.example;

import java.util.Arrays;
import java.util.Random;

public class FisherYatesShuffleAlgorithm {
    public static String yatesShuffle(int[] array) {
        long startTime = System.nanoTime();
        Random random = new Random();
        int m = array.length, t, i;

        // While there remain elements to shuffle…
        while (m > 0) {
            // Pick a remaining element…
            i = random.nextInt(m--);

            // And swap it with the current element.
            t = array[m];
            array[m] = array[i];
            array[i] = t;
        }
        System.out.println("\nThe Fisher-Yates Algorithm:");
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
        return Arrays.toString(array);
    }
}
