package com.shields.leastresistance;

public class LeastResistance {
    int[][] grid;
    String pathTaken = "";
    private String flowSucceeded = "Yes";

    public LeastResistance(int[][] grid) {
        this.grid = grid;
    }

    public boolean isGridValid() {
        boolean isValid = true;

        if((grid.length > 10) || (grid[0].length < 5) || (grid[0].length > 100))
            isValid = false;

        return isValid;
    }

    public int findResistance() {
        return findResistanceRecurse(0, 0);
    }

    public int findResistanceRecurse(int column, int resistance) {
        if(resistance > 50) {
            flowSucceeded = "No";
            return resistance;
        }
        if(column >= grid[0].length) {
            return resistance;
        }

        resistance += grid[0][column];
        pathTaken += 0 + 1 + " ";
        return findResistanceRecurse(column + 1, resistance);
    }

    public String getPathTaken() {
        return pathTaken.trim();
    }

    public String flowSucceeded() {
        return flowSucceeded;
    }
}
