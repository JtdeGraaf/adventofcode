package com.solutions.year2025.day3;

import com.Solution;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Solution for Advent of Code 2025 Day 2
 */
public class Day03 extends Solution {

    @Override
    public String solvePart1() {
        int totalJoltage = 0;

        for (String batteryBank : this.lines) {
            List<Integer> possibleJoltages = new ArrayList<>();
            findMaxNumberForFirstDigitIs(batteryBank, possibleJoltages, 9);
            findMaxNumberForFirstDigitIs(batteryBank, possibleJoltages, 8);
            findMaxNumberForFirstDigitIs(batteryBank, possibleJoltages, 7);
            findMaxNumberForFirstDigitIs(batteryBank, possibleJoltages, 6);
            findMaxNumberForFirstDigitIs(batteryBank, possibleJoltages, 5);
            findMaxNumberForFirstDigitIs(batteryBank, possibleJoltages, 4);
            findMaxNumberForFirstDigitIs(batteryBank, possibleJoltages, 3);
            findMaxNumberForFirstDigitIs(batteryBank, possibleJoltages, 2);
            findMaxNumberForFirstDigitIs(batteryBank, possibleJoltages, 1);

            int maxJoltageInBatteryBank = possibleJoltages.stream().max(Integer::compareTo).orElse(0);
            totalJoltage += maxJoltageInBatteryBank;
        }


        return String.valueOf(totalJoltage);
    }

    private static void findMaxNumberForFirstDigitIs(String batteryBank, List<Integer> possibleJoltages, int digit) {
        int firstDigitIndex = Strings.CS.indexOf(batteryBank, String.valueOf(digit));
        if (firstDigitIndex != -1) {
            String digitsAfterFirstDigit = batteryBank.substring(firstDigitIndex + 1).trim();
            if (digitsAfterFirstDigit.isEmpty()) {
                return;
            }
            String secondDigit = digitsAfterFirstDigit.chars()
                    .mapToObj(c -> Character.toString((char) c))
                    .map(Integer::parseInt)
                    .max(Integer::compareTo)
                    .orElse(0)
                    .toString();

            possibleJoltages.add(Integer.parseInt(digit + secondDigit));
        }
    }

    @Override
    public String solvePart2() {
        BigInteger totalJoltage = BigInteger.ZERO;

        for (String batteryBank : this.lines) {
            batteryBank = batteryBank.trim();
            String batteryBankJoltage = "";

            Pair<String, String> result = findDigitAtSpot(batteryBank, 1);
            batteryBankJoltage += result.getLeft();
            batteryBank = result.getRight();

            result = findDigitAtSpot(batteryBank, 2);
            batteryBankJoltage += result.getLeft();
            batteryBank = result.getRight();

            result = findDigitAtSpot(batteryBank, 3);
            batteryBankJoltage += result.getLeft();
            batteryBank = result.getRight();

            result = findDigitAtSpot(batteryBank, 4);
            batteryBankJoltage += result.getLeft();
            batteryBank = result.getRight();

            result = findDigitAtSpot(batteryBank, 5);
            batteryBankJoltage += result.getLeft();
            batteryBank = result.getRight();

            result = findDigitAtSpot(batteryBank, 6);
            batteryBankJoltage += result.getLeft();
            batteryBank = result.getRight();

            result = findDigitAtSpot(batteryBank, 7);
            batteryBankJoltage += result.getLeft();
            batteryBank = result.getRight();

            result = findDigitAtSpot(batteryBank, 8);
            batteryBankJoltage += result.getLeft();
            batteryBank = result.getRight();

            result = findDigitAtSpot(batteryBank, 9);
            batteryBankJoltage += result.getLeft();
            batteryBank = result.getRight();

            result = findDigitAtSpot(batteryBank, 10);
            batteryBankJoltage += result.getLeft();
            batteryBank = result.getRight();

            result = findDigitAtSpot(batteryBank, 11);
            batteryBankJoltage += result.getLeft();
            batteryBank = result.getRight();

            result = findDigitAtSpot(batteryBank, 12);
            batteryBankJoltage += result.getLeft();

            totalJoltage = totalJoltage.add(BigInteger.valueOf(Long.parseLong(batteryBankJoltage)));


        }


        return String.valueOf(totalJoltage);
    }

    private static Pair<String, String> findDigitAtSpot(String remainingBatteryBank, int spot) {
        int minusIndex = 12 - spot;
        String digit = remainingBatteryBank.substring(0, remainingBatteryBank.length() - minusIndex)
                .chars()
                .mapToObj(c -> Character.toString((char) c))
                .map(Integer::parseInt)
                .max(Integer::compareTo)
                .orElse(0)
                .toString();
        remainingBatteryBank = remainingBatteryBank.substring(remainingBatteryBank.indexOf(digit) + 1);

        return Pair.of(digit, remainingBatteryBank);
    }
}

