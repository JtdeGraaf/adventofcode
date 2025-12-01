package com;

/**
 * Advent of Code CLI Runner
 */
public class Main {
    static void main(String[] args) {

        IO.println("==============================================");
        IO.println("    🎄 Advent of Code Solution Runner 🎄");
        IO.println("==============================================");
        IO.println();

        while (true) {
            // Get year
            IO.print("Enter year (e.g., 2025) or 'q' to quit: ");
            String yearInput = IO.readLine().trim();

            if (yearInput.equalsIgnoreCase("q") || yearInput.equalsIgnoreCase("quit")) {
                IO.println("Goodbye! 🎄");
                break;
            }

            int year;
            try {
                year = Integer.parseInt(yearInput);
            } catch (NumberFormatException e) {
                IO.println("Invalid year. Please enter a valid number.");
                IO.println();
                continue;
            }

            // Get day
            IO.print("Enter day (1-25): ");
            String dayInput = IO.readLine().trim();

            int day;
            try {
                day = Integer.parseInt(dayInput);
                if (day < 1 || day > 25) {
                    IO.println("Invalid day. Please enter a number between 1 and 25.");
                    IO.println();
                    continue;
                }
            } catch (NumberFormatException e) {
                IO.println("Invalid day. Please enter a valid number.");
                IO.println();
                continue;
            }

            // Get part
            IO.print("Enter part (1 or 2, or 'b' for both): ");
            String partInput = IO.readLine().trim();

            boolean runPart1 = false;
            boolean runPart2 = false;

            if (partInput.equals("1")) {
                runPart1 = true;
            } else if (partInput.equals("2")) {
                runPart2 = true;
            } else if (partInput.equalsIgnoreCase("b") || partInput.equalsIgnoreCase("both")) {
                runPart1 = true;
                runPart2 = true;
            } else {
                IO.println("Invalid part. Please enter 1, 2, or 'b'.");
                IO.println();
                continue;
            }

            IO.println();
            IO.println("----------------------------------------------");
            IO.println(String.format("Running Year %d, Day %d", year, day));
            IO.println("----------------------------------------------");

            // Check if solution exists
            if (!SolutionRegistry.hasSolution(year, day)) {
                IO.println("❌ No solution registered for Year " + year + ", Day " + day);
                IO.println("Please implement the solution class and add it to the SolutionRegistry enum");
                IO.println();
                continue;
            }

            // Read input file
            String input = IO.readInputFile(year, day);
            if (input.isEmpty() && !IO.inputFileExists(year, day)) {
                IO.println("⚠️  Warning: No input file found. Expected location:");
                IO.println(String.format("   src/main/resources/year%d/day%02d.txt", year, day));
                IO.println();
            }

            // Get solution
            Solution solution = SolutionRegistry.getSolution(year, day);

            // Set input on the solution
            solution.setInput(input);

            // Run solution
            try {
                if (runPart1) {
                    IO.println("Running Part 1...");
                    long startTime = System.nanoTime();
                    String result = solution.solvePart1();
                    long endTime = System.nanoTime();
                    double timeMs = (endTime - startTime) / 1_000_000.0;

                    IO.println("Part 1 Result: " + result);
                    IO.println(String.format("Time: %.3f ms", timeMs));
                    IO.println();
                }

                if (runPart2) {
                    IO.println("Running Part 2...");
                    long startTime = System.nanoTime();
                    String result = solution.solvePart2();
                    long endTime = System.nanoTime();
                    double timeMs = (endTime - startTime) / 1_000_000.0;

                    IO.println("Part 2 Result: " + result);
                    IO.println(String.format("Time: %.3f ms", timeMs));
                    IO.println();
                }

                IO.println("✅ Completed!");
            } catch (Exception e) {
                IO.println("❌ Error running solution: " + e.getMessage());
                e.printStackTrace();
            }

            IO.println();
        }
    }
}
