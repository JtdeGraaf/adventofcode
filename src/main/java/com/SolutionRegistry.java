package com;

import com.solutions.year2025.day1.Day01;
import com.solutions.year2025.day2.Day02;
import com.solutions.year2025.day3.Day03;
import com.solutions.year2025.day4.Day04;

import java.util.function.Supplier;

/**
 * Registry to store and retrieve solutions for specific years and days using enums
 */
public enum SolutionRegistry {
    YEAR2025_DAY01(2025, 1, Day01::new),
    YEAR2025_DAY02(2025, 2, Day02::new),
    YEAR2025_DAY03(2025, 3, Day03::new),
    YEAR2025_DAY04(2025, 4, Day04::new);

    private final int year;
    private final int day;
    private final Supplier<Solution> solutionSupplier;

    SolutionRegistry(int year, int day, Supplier<Solution> solutionSupplier) {
        this.year = year;
        this.day = day;
        this.solutionSupplier = solutionSupplier;
    }

    /**
     * Get a solution instance for a specific year and day
     */
    public static Solution getSolution(int year, int day) {
        for (SolutionRegistry entry : values()) {
            if (entry.year == year && entry.day == day) {
                return entry.solutionSupplier.get();
            }
        }
        return null;
    }

    /**
     * Check if a solution exists for a specific year and day
     */
    public static boolean hasSolution(int year, int day) {
        for (SolutionRegistry entry : values()) {
            if (entry.year == year && entry.day == day) {
                return true;
            }
        }
        return false;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }
}


