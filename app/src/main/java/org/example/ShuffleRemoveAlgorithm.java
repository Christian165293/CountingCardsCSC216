package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleRemoveAlgorithm {
    public static List<Integer> shuffleRemove(List<Integer> array) {
        long startTime = System.nanoTime();
        List<Integer> copy = new ArrayList<>();
        int n = array.size();
        Random random = new Random();

        // While there remain elements to shuffle…
        while (n > 0) {
            // Pick a remaining element…
            int i = random.nextInt(n--);

            // And move it to the new array.
            copy.add(array.remove(i));
        }
        System.out.println("\nThe Second Algorithm:");
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
        return copy;
    }
}
