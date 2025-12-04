package com.solutions.year2025.day4;

import com.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for Advent of Code 2025 Day 4
 */
public class Day04 extends Solution {

    private static final String ROLL_OF_PAPER = "@";

    @Override
    public String solvePart1() {
        // Map input lines to 2d array
        List<List<String>> grid = Arrays.stream(this.lines).map(line -> Arrays.asList(line.split(""))).toList();
        int accessiblePaperRolls = 0;

        for (int rowIndex = 0; rowIndex < grid.size(); rowIndex++) {
            List<String> row = grid.get(rowIndex);
            for (int columnIndex = 0; columnIndex < row.size(); columnIndex++) {
                String cell = row.get(columnIndex);
                if (!ROLL_OF_PAPER.equals(cell)) {
                    continue;
                }
                List<String> surroundingCells = new ArrayList<>();
                // Get surrounding cells starting from top left
                // Why handle edge cases when you can just ignore them?
                try {
                    surroundingCells.add(grid.get(rowIndex - 1).get(columnIndex - 1));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex - 1).get(columnIndex));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex - 1).get(columnIndex + 1));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex).get(columnIndex - 1));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex).get(columnIndex + 1));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex + 1).get(columnIndex - 1));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex + 1).get(columnIndex));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex + 1).get(columnIndex + 1));
                } catch (Exception ignored) {
                }

                if (surroundingCells.stream().filter(ROLL_OF_PAPER::equals).count() < 4) {
                    accessiblePaperRolls++;
                }


            }
        }

        return String.valueOf(accessiblePaperRolls);
    }

    @Override
    public String solvePart2() {
        // Map input lines to 2d array
        List<List<String>> grid = Arrays.stream(this.lines).map(line -> Arrays.asList(line.split(""))).toList();
        int accessiblePaperRolls = 0;

        accessiblePaperRolls = getAccessiblePaperRolls(grid, accessiblePaperRolls);

        return String.valueOf(accessiblePaperRolls);
    }

    private static int getAccessiblePaperRolls(List<List<String>> grid, int accessiblePaperRolls) {
        int accessiblePaperRollsInRun = 0;
        for (int rowIndex = 0; rowIndex < grid.size(); rowIndex++) {
            List<String> row = grid.get(rowIndex);
            for (int columnIndex = 0; columnIndex < row.size(); columnIndex++) {
                String cell = row.get(columnIndex);
                if (!ROLL_OF_PAPER.equals(cell)) {
                    continue;
                }
                List<String> surroundingCells = new ArrayList<>();
                // Get surrounding cells starting from top left
                // Why handle edge cases when you can just ignore them?
                try {
                    surroundingCells.add(grid.get(rowIndex - 1).get(columnIndex - 1));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex - 1).get(columnIndex));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex - 1).get(columnIndex + 1));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex).get(columnIndex - 1));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex).get(columnIndex + 1));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex + 1).get(columnIndex - 1));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex + 1).get(columnIndex));
                } catch (Exception ignored) {
                }
                try {
                    surroundingCells.add(grid.get(rowIndex + 1).get(columnIndex + 1));
                } catch (Exception ignored) {
                }

                if (surroundingCells.stream().filter(ROLL_OF_PAPER::equals).count() < 4) {
                    accessiblePaperRolls++;
                    accessiblePaperRollsInRun++;
                    row.set(columnIndex, "X");
                }

            }
        }

        // Recursively call until no more accessible paper rolls are found
        if (accessiblePaperRollsInRun != 0) {
            return getAccessiblePaperRolls(grid, accessiblePaperRolls);
        }
        return accessiblePaperRolls;
    }

}

