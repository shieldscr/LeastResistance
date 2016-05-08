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
        int totalResistance = 0;

        for(int column = 0; column < grid[0].length; column++) {
            totalResistance += grid[0][column];
            if(totalResistance > 50) {
                flowSucceeded = "No";
                break;
            }
            pathTaken += 0 + 1 + " ";
        }

        return totalResistance;
    }

    public String getPathTaken() {
        return pathTaken.trim();
    }

    public String flowSucceeded() {
        return flowSucceeded;
    }
}
