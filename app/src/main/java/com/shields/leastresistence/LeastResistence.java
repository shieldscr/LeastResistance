package com.shields.leastresistence;

public class LeastResistence {
    //rows columns
    int[][] grid;

    public LeastResistence(int[][] grid) {
        this.grid = grid;
    }

    public boolean isGridValid() {
        boolean isValid = true;

        if((grid.length > 10) || (grid[0].length < 5) || (grid[0].length > 100))
            isValid = false;

        return isValid;
    }

    public int getTotalResistence() {
        int totalResistence = 0;

        for(int column = 0; column < grid[0].length; column++) {
            totalResistence += grid[0][column];
        }

        return totalResistence;
    }
}
