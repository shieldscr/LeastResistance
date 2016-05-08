package com.shields.leastresistence;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeastResistenceTest {
    @Test
    public void minimumValidGridSizeIsOneRowAndFiveColumns() {
        int[][] grid = {{1, 2, 3, 4, 5}};

        LeastResistence leastResistence = new LeastResistence(grid);

        assertTrue(leastResistence.isGridValid());
    }

    @Test
    public void validGridCannotBeLessThanFiveRows() {
        int[][] grid = {{1, 2, 3}};

        LeastResistence leastResistence = new LeastResistence(grid);

        assertFalse(leastResistence.isGridValid());
    }

    @Test
    public void validGridCannotBeLargerThanTenRows() {
        int[][] invalidGrid = {{1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {9, 9, 9, 9, 9}};

        LeastResistence leastResistence = new LeastResistence(invalidGrid);

        assertFalse(leastResistence.isGridValid());
    }

    @Test
    public void validGridCannotBeLargerThanOneHundredColumns() {
        int[][] invalidGrid = buildGridOfSize(1, 101);

        LeastResistence leastResistence = new LeastResistence(invalidGrid);

        assertFalse(leastResistence.isGridValid());
    }

    @Test
    public void validGridCanBeOneHundredColumns() {
        int[][] invalidGrid = buildGridOfSize(1, 100);

        LeastResistence leastResistence = new LeastResistence(invalidGrid);

        assertTrue(leastResistence.isGridValid());
    }

    private int[][] buildGridOfSize(int rows, int columns) {
        int[][] generatedArray = new int[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                generatedArray[i][j] = 9;
            }
        }

        return generatedArray;
    }
}