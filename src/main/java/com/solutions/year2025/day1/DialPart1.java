package com.solutions.year2025.day1;

public class DialPart1 {
    public static final int STARTING_POSITION = 50;
    private static final int MAX_POSITION = 99;
    private static final int MIN_POSITION = 0;

    private DialPart1() {}

    public static int turnDial(int currentPosition, String instruction) {
        Direction direction = instruction.charAt(0) == 'R' ? Direction.R : Direction.L;
        String number = instruction.substring(1).trim();
        int steps = Integer.parseInt(number);

        if (direction == Direction.R) {
            return turnRight(currentPosition, steps);
        }
        return turnLeft(currentPosition, steps);
    }

    private static int turnRight(int currentPosition, int steps) {
        int newPosition = currentPosition + steps;
        while (newPosition > MAX_POSITION) {
            newPosition = newPosition - (MAX_POSITION + 1);
        }
        return newPosition;
    }

    private static int turnLeft(int currentPosition, int steps) {
        int newPosition = currentPosition - steps;
        while (newPosition < MIN_POSITION) {
            newPosition = (MAX_POSITION + 1) + newPosition;
        }
        return newPosition;
    }
}
