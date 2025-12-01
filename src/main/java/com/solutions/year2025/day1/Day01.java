package com.solutions.year2025.day1;

import com.Solution;

/**
 * Solution for Advent of Code 2025 Day 1
 */
public class Day01 extends Solution {

    /**
     * Return amount of times the dial lands on position 0 after a full instruction
     */
    @Override
    public String solvePart1() {
        int currentPosition = DialPart1.STARTING_POSITION;
        int timesAtZero = 0;
        for(String line: this.lines) {
            currentPosition = DialPart1.turnDial(currentPosition, line);
            if (currentPosition == 0) {
                timesAtZero++;
            }
        }

        return String.valueOf(timesAtZero);
    }

    /**
     * Return amount of times the dial lands on position 0 any time
     */
    @Override
    public String solvePart2() {
        int currentPosition = DialPart2.STARTING_POSITION;
        int timesAtZero = 0;

        for(String line: this.lines) {
            DialResult dialResult = DialPart2.turnDial(currentPosition, line, timesAtZero);
            currentPosition = dialResult.position();
            timesAtZero = dialResult.timesAtZero();
        }

        return String.valueOf(timesAtZero);
    }
}

