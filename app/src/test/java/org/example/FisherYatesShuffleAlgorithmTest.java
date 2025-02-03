package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;


class FisherYatesShuffleAlgorithmTest {

    @Test
    public void testYatesShuffle_ShufflesArray() {
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] arrayToShuffle = Arrays.copyOf(originalArray, originalArray.length);

        String shuffledArrayString = FisherYatesShuffleAlgorithm.yatesShuffle(arrayToShuffle);

        String[] shuffledElements = shuffledArrayString.replace("[", "").replace("]", "").split(", ");
        int[] shuffledArray = Arrays.stream(shuffledElements).mapToInt(Integer::parseInt).toArray();

        assertArrayEquals(Arrays.stream(originalArray).sorted().toArray(), Arrays.stream(shuffledArray).sorted().toArray());

        assertFalse(Arrays.equals(originalArray, shuffledArray));
    }

    @Test
    public void testYatesShuffle_EmptyArray() {
        int[] emptyArray = {};
        String result = FisherYatesShuffleAlgorithm.yatesShuffle(emptyArray);

        assertEquals("[]", result);
    }

    @Test
    public void testYatesShuffle_SingleElementArray() {
        int[] singleElementArray = {42};
        String result = FisherYatesShuffleAlgorithm.yatesShuffle(singleElementArray);

        assertEquals("[42]", result);
    }

    @Test
    public void testYatesShuffle_Timing() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long startTime = System.nanoTime();
        FisherYatesShuffleAlgorithm.yatesShuffle(array);
        long endTime = System.nanoTime();

        assertTrue((endTime - startTime) < 1_000_000_000L); // Less than 1 second
    }
}