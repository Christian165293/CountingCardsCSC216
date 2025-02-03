package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleCheckAlgorithm {
    public List<Integer> shuffleCheck(List<Integer> array) {
        long startTime = System.nanoTime();
        List<Integer> copy = new ArrayList<>();
        int n = array.size();
        Random random = new Random();

        // While there remain elements to shuffle…
        while (n > 0) {
            // Pick a remaining element…
            int i = random.nextInt(array.size());

            // If not already shuffled, move it to the new array.
            if (i < array.size()) {
                copy.add(array.get(i));
                array.remove(i);
                n--;
            }
        }
        System.out.println("\nThe First Algorithm:");
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
        return copy;
    }
}
