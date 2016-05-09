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
        return findResistanceRecurse(0, 0, 0);
    }

    public int findResistanceRecurse(int column, int row, int resistance) {
        if(resistance > 50) {
            flowSucceeded = "No";
            return resistance;
        }

        if(column >= grid[0].length) {
            return resistance;
        }

        resistance += grid[row][column];
        pathTaken += row + 1 + " ";

        int nextAdjacent = 99;
        if(column + 1 < grid[0].length) {
            nextAdjacent = grid[row][column + 1];
        }

        if (row + 1 < grid.length) {
            if (grid[row + 1][column + 1] < nextAdjacent) {
                return findResistanceRecurse(column + 1, row + 1, resistance);
            } else {
                return findResistanceRecurse(column + 1, row, resistance);
            }
        }

        return findResistanceRecurse(column + 1, row, resistance);
    }

    public String getPathTaken() {
        return pathTaken.trim();
    }

    public String flowSucceeded() {
        return flowSucceeded;
    }
}
