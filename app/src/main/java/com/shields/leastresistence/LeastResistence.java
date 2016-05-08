package com.shields.leastresistence;

public class LeastResistence {
    int[][] grid;
    String pathTaken = "";
    private String flowSucceeded = "Yes";

    public LeastResistence(int[][] grid) {
        this.grid = grid;
    }

    public boolean isGridValid() {
        boolean isValid = true;

        if((grid.length > 10) || (grid[0].length < 5) || (grid[0].length > 100))
            isValid = false;

        return isValid;
    }

    public int findResistance() {
        int totalResistence = 0;

        for(int column = 0; column < grid[0].length; column++) {
            totalResistence += grid[0][column];
            if(totalResistence > 50) {
                flowSucceeded = "No";
                break;
            }
            pathTaken += 0 + 1 + " ";
        }

        return totalResistence;
    }

    public String getPathTaken() {
        return pathTaken.trim();
    }

    public String flowSucceeded() {
        return flowSucceeded;
    }
}
