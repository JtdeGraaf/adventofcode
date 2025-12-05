package com.solutions.year2025.day5;

import com.Solution;
import org.apache.commons.lang3.Range;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day05 extends Solution {
    @Override
    public String solvePart1() {
        List<Range<Long>> freshIngredientRanges = new ArrayList<>();
        List<Long> availableIngredientIds = new ArrayList<>();

        boolean isIngredientRange = true;
        for (String range : this.lines) {
            range = range.trim();
            if (range.isBlank()) {
                isIngredientRange = false;
                continue;
            }
            if (isIngredientRange) {
                List<String> rangeParts = List.of(range.split("-"));
                Long firstInclusive = Long.parseLong(String.valueOf(rangeParts.getFirst()));
                Long secondInclusive = Long.parseLong(String.valueOf(rangeParts.getLast()));
                freshIngredientRanges.add(Range.of(firstInclusive, secondInclusive));
            }
            if (!isIngredientRange) {
                availableIngredientIds.add(Long.parseLong(range));
            }
        }

        Long availableFreshIngredients = 0L;
        for (Long ingredientId : availableIngredientIds) {
            for (Range<Long> freshIngredientRange : freshIngredientRanges) {
                if (freshIngredientRange.contains(ingredientId)) {
                    availableFreshIngredients++;
                    break;
                }
            }
        }

        return String.valueOf(availableFreshIngredients);
    }

    @Override
    public String solvePart2() {
        List<Range<Long>> freshIngredientRanges = new ArrayList<>();
        for (String range : this.lines) {
            range = range.trim();
            if (range.isBlank()) {
                break;
            }

            List<String> rangeParts = List.of(range.split("-"));
            Long firstInclusive = Long.parseLong(String.valueOf(rangeParts.getFirst()));
            Long secondInclusive = Long.parseLong(String.valueOf(rangeParts.getLast()));
            freshIngredientRanges.add(Range.of(firstInclusive, secondInclusive));
        }
        // First sort the ranges by the minimum value
        freshIngredientRanges.sort(Comparator.comparingLong(Range::getMinimum));

        // Merge overlapping ranges
        List<Range<Long>> mergedRanges = new ArrayList<>();
        for (Range<Long> range : freshIngredientRanges) {
            if (mergedRanges.isEmpty()) {
                // First range, add it directly
                mergedRanges.add(range);
                continue;
            }
            Range<Long> lastRange = mergedRanges.getLast();
            // Check if current range overlaps with the last merged range
            if (range.getMinimum() <= lastRange.getMaximum() + 1) {
                // Merge the ranges by extending the last range
                Range<Long> extended = Range.of(
                        lastRange.getMinimum(),
                        Math.max(lastRange.getMaximum(), range.getMaximum())
                );
                mergedRanges.set(mergedRanges.size() - 1, extended);
                continue;
            }
            // No overlap, add as a new range
            mergedRanges.add(range);

        }

        Long amountOfFreshIngredients = mergedRanges.stream()
                .map((range) -> range.getMaximum() - range.getMinimum() + 1)
                .reduce(Long::sum)
                .orElse(0L);

        return String.valueOf(amountOfFreshIngredients);
    }
}
