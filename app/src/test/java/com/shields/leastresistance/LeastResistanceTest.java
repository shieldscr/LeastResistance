package com.shields.leastresistance;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeastResistanceTest {
    @Test
    public void minimumValidGridSizeIsOneRowAndFiveColumns() {
        int[][] grid = {{1, 2, 3, 4, 5}};

        LeastResistance leastResistance = new LeastResistance(grid);

        assertTrue(leastResistance.isGridValid());
    }

    @Test
    public void validGridCannotBeLessThanFiveRows() {
        int[][] grid = {{1, 2, 3}};

        LeastResistance leastResistance = new LeastResistance(grid);

        assertFalse(leastResistance.isGridValid());
    }

    @Test
    public void validGridCannotBeLargerThanTenRows() {
        int[][] invalidGrid = buildGridOfSize(11, 5);

        LeastResistance leastResistance = new LeastResistance(invalidGrid);

        assertFalse(leastResistance.isGridValid());
    }

    @Test
    public void validGridCannotBeLargerThanOneHundredColumns() {
        int[][] invalidGrid = buildGridOfSize(1, 101);

        LeastResistance leastResistance = new LeastResistance(invalidGrid);

        assertFalse(leastResistance.isGridValid());
    }

    @Test
    public void validGridCanBeOneHundredColumns() {
        int[][] invalidGrid = buildGridOfSize(1, 100);

        LeastResistance leastResistance = new LeastResistance(invalidGrid);

        assertTrue(leastResistance.isGridValid());
    }

    @Test
    public void simpleResistanceCanBeCalculatedForOneRow() {
        int[][] grid = {{1, 1, 1}};

        LeastResistance leastResistance = new LeastResistance(grid);

        assertEquals(3, leastResistance.findResistance());
    }

    @Test
    public void resistancePathTakenCanBeReturned() {
        int[][] grid = {{1, 1, 1}};

        LeastResistance leastResistance = new LeastResistance(grid);

        leastResistance.findResistance();
        assertEquals("1 1 1", leastResistance.getPathTaken());
    }

    @Test
    public void whenResistanceIsGreaterThanFiftyThenFlowStops() {
        int[][] grid = {{1, 49, 1}};

        LeastResistance leastResistance = new LeastResistance(grid);

        leastResistance.findResistance();
        assertEquals("No", leastResistance.flowSucceeded());
    }

    @Test
    public void whenResistanceIsLessThanFiftyThenFlowSucceeds() {
        int[][] grid = {{1, 25, 10}};

        LeastResistance leastResistance = new LeastResistance(grid);

        assertEquals(36, leastResistance.findResistance());
        assertEquals("Yes", leastResistance.flowSucceeded());
    }

    @Test
    public void fiveColumnGridResistanceIsCalculatedCorrectly() {
        int[][] grid = {{1, 2, 3, 4, 5}};

        LeastResistance leastResistance = new LeastResistance(grid);

        assertEquals(15, leastResistance.findResistance());
        assertEquals("Yes", leastResistance.flowSucceeded());
        assertEquals("1 1 1 1 1", leastResistance.getPathTaken());
    }

    @Test
    public void twoRowGridResistanceBestPathCanBeFound() {
        int[][] grid = {
                {1, 99, 99},
                {1, 1, 1}
        };

        LeastResistance leastResistance = new LeastResistance(grid);
        leastResistance.findResistance();

        assertEquals("1 2 2", leastResistance.getPathTaken());
    }

    @Test
    public void twoRowGridWithAlternatingBestPathCanBeFound() {
        int [][] grid = {
                {1, 99, 1},
                {99, 1, 99}
        };

        LeastResistance leastResistance = new LeastResistance(grid);
        leastResistance.findResistance();

        assertEquals("1 2 1", leastResistance.getPathTaken());
    }

    @Test
    public void twoRowGridWithFiveColumnsBestPathCanBeFound() {
        int [][] grid = {
                {1, 99, 1, 99, 1},
                {99, 1, 99, 1, 99}
        };

        LeastResistance leastResistance = new LeastResistance(grid);
        leastResistance.findResistance();

        assertEquals("1 2 1 2 1", leastResistance.getPathTaken());
    }

    @Test
    public void fiveRowGridWithFiveColumnsBestPathCanBeFound() {
        int [][] grid = {
                {1, 99, 1, 99, 99},
                {99, 1, 99, 99, 99},
                {99, 99, 1, 99, 99},
                {99, 99, 99, 1, 99},
                {99, 99, 99, 99, 1}
        };

        LeastResistance leastResistance = new LeastResistance(grid);
        leastResistance.findResistance();

        assertEquals("1 2 3 4 5", leastResistance.getPathTaken());
    }

    @Test
    public void fiveRowGridWithManyValidCostsBestPathCanBeFound() {
        int [][] grid = {
                {1, 9, 1, 9, 9},
                {1, 1, 9, 1, 9},
                {9, 9, 1, 9, 10},
                {1, 9, 9, 1, 9},
                {1, 9, 9, 9, 1}
        };

        LeastResistance leastResistance = new LeastResistance(grid);
        leastResistance.findResistance();

        assertEquals("1 2 3 4 5", leastResistance.getPathTaken());
    }

    @Test
    public void sixRowFiveColumnBestPathCanBeFound() {
        int [][] grid = {
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 8, 6, 4}
        };

        LeastResistance leastResistance = new LeastResistance(grid);
        int actualResistance = leastResistance.findResistance();

        assertEquals(16, actualResistance);
        assertEquals("Yes", leastResistance.flowSucceeded());
        assertEquals("1 2 3 4 4 5", leastResistance.getPathTaken());
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