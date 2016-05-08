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
        int[][] invalidGrid = buildGridOfSize(11, 5);

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

    @Test
    public void simpleResistenceCanBeCalculatedForOneRow() {
        int[][] grid = {{1, 1, 1}};

        LeastResistence leastResistence = new LeastResistence(grid);

        assertEquals(3, leastResistence.findResistance());
    }

    @Test
    public void resistencePathTakenCanBeReturned() {
        int[][] grid = {{1, 1, 1}};

        LeastResistence leastResistence = new LeastResistence(grid);

        leastResistence.findResistance();
        assertEquals("1 1 1", leastResistence.getPathTaken());
    }

    @Test
    public void whenResistenceIsGreaterThanFiftyThenFlowStops() {
        int[][] grid = {{1, 49, 1}};

        LeastResistence leastResistence = new LeastResistence(grid);

        leastResistence.findResistance();
        assertEquals("No", leastResistence.flowSucceeded());
    }

    @Test
    public void whenResistenceIsLessThanFiftyThenFlowSucceeds() {
        int[][] grid = {{1, 25, 10}};

        LeastResistence leastResistence = new LeastResistence(grid);

        assertEquals(36, leastResistence.findResistance());
        assertEquals("Yes", leastResistence.flowSucceeded());
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