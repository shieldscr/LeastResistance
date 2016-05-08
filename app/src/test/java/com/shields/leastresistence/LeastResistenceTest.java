package com.shields.leastresistence;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeastResistenceTest {
    @Test
    public void minimumValidGridSizeIsOneRowAndFiveColumns() {
        int[][] grid = {{1, 2, 3, 4, 5}};

        LeastResistence leastResistence = new LeastResistence(grid);

        assertTrue(leastResistence.validateGrid());
    }
}