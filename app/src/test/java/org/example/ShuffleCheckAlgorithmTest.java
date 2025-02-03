package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShuffleCheckAlgorithmTest {

    @Test
    public void testShuffleCheck_NonEmptyList() {
        ShuffleCheckAlgorithm shuffleCheckAlgorithm = new ShuffleCheckAlgorithm();
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        List<Integer> shuffledArray = shuffleCheckAlgorithm.shuffleCheck(array);

        assertEquals(5, shuffledArray.size(), "The shuffled array should have the same size as the original array.");

        assertTrue(array.isEmpty(), "The original array should be empty after shuffling.");

        assertTrue(shuffledArray.containsAll(List.of(1, 2, 3, 4, 5)), "The shuffled array should contain all elements of the original array.");
    }

    @Test
    public void testShuffleCheck_SingleElementList() {
        ShuffleCheckAlgorithm shuffleCheckAlgorithm = new ShuffleCheckAlgorithm();
        List<Integer> array = new ArrayList<>();
        array.add(42);

        List<Integer> shuffledArray = shuffleCheckAlgorithm.shuffleCheck(array);

        assertEquals(1, shuffledArray.size(), "The shuffled array should have the same size as the original array.");

        assertTrue(array.isEmpty(), "The original array should be empty after shuffling.");

        assertEquals(42, shuffledArray.get(0), "The shuffled array should contain the single element.");
    }

    @Test
    public void testShuffleCheck_EmptyList() {
        ShuffleCheckAlgorithm shuffleCheckAlgorithm = new ShuffleCheckAlgorithm();
        List<Integer> array = new ArrayList<>();

        List<Integer> shuffledArray = shuffleCheckAlgorithm.shuffleCheck(array);

        assertTrue(shuffledArray.isEmpty(), "The shuffled array should be empty.");

        assertTrue(array.isEmpty(), "The original array should remain empty.");
    }

    @Test
    public void testShuffleCheck_LargeList() {
        ShuffleCheckAlgorithm shuffleCheckAlgorithm = new ShuffleCheckAlgorithm();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            array.add(i);
        }

        List<Integer> shuffledArray = shuffleCheckAlgorithm.shuffleCheck(array);

        assertEquals(1000, shuffledArray.size(), "The shuffled array should have the same size as the original array.");

        assertTrue(array.isEmpty(), "The original array should be empty after shuffling.");

        for (int i = 0; i < 1000; i++) {
            assertTrue(shuffledArray.contains(i), "The shuffled array should contain all elements of the original array.");
        }
    }

    @Test
    public void testShuffleCheck_CheckShuffledOrder() {
        ShuffleCheckAlgorithm shuffleCheckAlgorithm = new ShuffleCheckAlgorithm();
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        List<Integer> shuffledArray = shuffleCheckAlgorithm.shuffleCheck(array);

        assertNotEquals(List.of(1, 2, 3, 4, 5), shuffledArray, "The shuffled array should not be in the same order as the original array.");
    }
}