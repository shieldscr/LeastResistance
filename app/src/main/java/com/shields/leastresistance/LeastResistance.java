package com.shields.leastresistance;

public class LeastResistance {
    public static final int MAX_PATH_COST = 50;

    int[][] grid;

    private int lowestCostResistance;
    private String pathTaken;
    private String flowSucceeded;

    public LeastResistance(int[][] grid) {
        this.grid = grid;
        pathTaken = "";
        lowestCostResistance = 55;
        flowSucceeded = "Yes";
    }

    public boolean isGridValid() {
        boolean isValid = true;

        if((grid.length > 10) || (grid[0].length < 5) || (grid[0].length > 100))
            isValid = false;

        return isValid;
    }

    public int findResistance() {
        findResistanceRecurse(0, 0, 0, "");
        return lowestCostResistance;
    }

    public void findResistanceRecurse(int column, int row, int resistance, String currentPath) {
        row = resetRows(row);
        resistance += grid[row][column];

        if (resistance > MAX_PATH_COST) {
            if (column >= grid[0].length)
                pathTaken = currentPath;

            flowSucceeded = "No";
            lowestCostResistance = resistance;
            return;
        }

        currentPath += row + 1 + " ";

        if (endColumnReached(column)) {
            if (lowestCostResistance > resistance) {
                lowestCostResistance = resistance;
                pathTaken = currentPath;
            }
        } else {
            findResistanceRecurse(column + 1, row + 1, resistance, currentPath);
            findResistanceRecurse(column + 1, row, resistance, currentPath);
            findResistanceRecurse(column + 1, row - 1, resistance, currentPath);
        }
    }

    private boolean endColumnReached(int column) {
        return column == grid[0].length - 1;
    }

    private int resetRows(int row) {
        if (row < 0)
            row = grid.length - 1;
        if (row == grid.length)
            row = 0;
        return row;
    }

    public String getPathTaken() {
        return pathTaken.trim();
    }

    public String flowSucceeded() {
        return flowSucceeded;
    }
}
