package com.solutions.year2025.day1;

public class DialPart2 {
    public static final int STARTING_POSITION = 50;
    private static final int MAX_POSITION = 99;
    private static final int MIN_POSITION = 0;

    private DialPart2() {}

    public static DialResult turnDial(int currentPosition, String instruction, int timesAtZero) {
        Direction direction = instruction.charAt(0) == 'R' ? Direction.R : Direction.L;
        String number = instruction.substring(1).trim();
        int steps = Integer.parseInt(number);

        if (direction == Direction.R) {
            return turnRight(currentPosition, steps, timesAtZero);
        }
        return turnLeft(currentPosition, steps, timesAtZero);
    }

    private static DialResult turnRight(int currentPosition, int steps, int timesAtZero) {
        int newPosition = currentPosition;
        for(int i = 0; i < steps; i++) {
            newPosition = currentPosition + 1;
            if (newPosition > MAX_POSITION) {
                newPosition = MIN_POSITION;
            }
            currentPosition = newPosition;
            if (newPosition == 0) {
                timesAtZero = timesAtZero + 1;
            }
        }
        return new DialResult(newPosition, timesAtZero);
    }

    private static DialResult turnLeft(int currentPosition, int steps, int timesAtZero) {
        int newPosition = currentPosition;
        for(int i = 0; i < steps; i++) {
            newPosition = currentPosition - 1;
            if (newPosition < MIN_POSITION) {
                newPosition = MAX_POSITION;
            }
            currentPosition = newPosition;
            if (newPosition == 0) {
                timesAtZero = timesAtZero + 1;
            }
        }
        return new DialResult(newPosition, timesAtZero);
    }
}
