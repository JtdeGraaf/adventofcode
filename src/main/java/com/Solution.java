package com;

/**
 * Abstract base class for all Advent of Code solutions
 * Provides input management and helper methods
 */
public abstract class Solution {
    protected String input;
    protected String[] lines;

    /**
     * Initialize the solution with puzzle input
     * @param input The raw puzzle input as a string
     */
    public void setInput(String input) {
        this.input = input;
        this.lines = input.split("\n");
    }

    /**
     * Solve part 1 of the day's challenge
     * @return The solution as a string
     */
    public abstract String solvePart1();

    /**
     * Solve part 2 of the day's challenge
     * @return The solution as a string
     */
    public abstract String solvePart2();

    // Helper methods for common operations

    /**
     * Get all lines as an array
     */
    protected String[] getLines() {
        return lines;
    }

    /**
     * Get input as a trimmed string
     */
    protected String getInput() {
        return input.trim();
    }

    /**
     * Split input by double newline (common for grouped data)
     */
    protected String[] getGroups() {
        return input.split("\n\n");
    }

    /**
     * Get lines as integers
     */
    protected int[] getLinesAsInts() {
        return input.lines()
                .filter(line -> !line.trim().isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    /**
     * Get lines as longs
     */
    protected long[] getLinesAsLongs() {
        return input.lines()
                .filter(line -> !line.trim().isEmpty())
                .mapToLong(Long::parseLong)
                .toArray();
    }
}

