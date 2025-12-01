package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Utility class for input/output operations
 */
public class IO {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Print a message to console
     */
    public static void println(String message) {
        System.out.println(message);
    }

    /**
     * Print a newline
     */
    public static void println() {
        println("");
    }

    /**
     * Print a message without newline
     */
    public static void print(String message) {
        System.out.print(message);
    }

    /**
     * Read a line from console input
     */
    public static String readLine() {
        return scanner.nextLine();
    }

    /**
     * Read an integer from console input
     */
    public static int readInt() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            print("Please enter a valid number: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }

    /**
     * Read input file for a specific year and day
     * Expected file location: src/main/resources/year{YEAR}/day{DAY}.txt
     */
    public static String readInputFile(int year, int day) {
        String filename = String.format("year%d/day%02d.txt", year, day);
        Path path = Paths.get("src/main/resources", filename);

        try {
            return Files.readString(path);
        } catch (IOException e) {
            println("Warning: Could not read input file: " + path);
            println("Error: " + e.getMessage());
            return "";
        }
    }

    /**
     * Check if input file exists for a specific year and day
     */
    public static boolean inputFileExists(int year, int day) {
        String filename = String.format("year%d/day%02d.txt", year, day);
        Path path = Paths.get("src/main/resources", filename);
        return Files.exists(path);
    }
}