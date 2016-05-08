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
}
