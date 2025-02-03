package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShuffleRemoveAlgorithmTest {

    private List<Integer> sampleList;

    @BeforeEach
    void setUp() {
        sampleList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void testShuffleRemoveReturnsCorrectSize() {
        List<Integer> result = ShuffleRemoveAlgorithm.shuffleRemove(new ArrayList<>(sampleList));
        assertEquals(sampleList.size(), result.size(), "The shuffled list should have the same size as the original.");
    }

    @Test
    void testShuffleRemoveContainsSameElements() {
        List<Integer> result = ShuffleRemoveAlgorithm.shuffleRemove(new ArrayList<>(sampleList));
        Collections.sort(result);
        assertEquals(sampleList, result, "The shuffled list should contain the same elements as the original.");
    }

    @Test
    void testShuffleRemoveOrderIsDifferent() {
        List<Integer> result = ShuffleRemoveAlgorithm.shuffleRemove(new ArrayList<>(sampleList));
        boolean differentOrder = !result.equals(sampleList);
        assertTrue(differentOrder || sampleList.size() <= 1, "The shuffle should produce a different order.");
    }

    @Test
    void testShuffleRemoveEmptyList() {
        List<Integer> result = ShuffleRemoveAlgorithm.shuffleRemove(new ArrayList<>());
        assertTrue(result.isEmpty(), "Shuffling an empty list should return an empty list.");
    }
}