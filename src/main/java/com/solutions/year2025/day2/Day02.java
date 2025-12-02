package com.solutions.year2025.day2;

import com.Solution;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * Solution for Advent of Code 2025 Day 2
 */
public class Day02 extends Solution {

    @Override
    public String solvePart1() {
        List<String> idRangeStrings = List.of(this.lines[0].split(","));
        List<Pair<String, String>> idRanges = idRangeStrings.stream().map(rangeStr -> {
            String[] splitIds = rangeStr.split("-");

            // Strip leading zeros from ids
            String startId = StringUtils.stripStart(splitIds[0], "0").trim();
            String endId = StringUtils.stripStart(splitIds[1], "0").trim();
            return Pair.of(startId, endId);
        }).toList();

        Long sumOfInvalidIds = 0L;


        for (Pair<String, String> idRange : idRanges) {
            Long startId = Long.parseLong(idRange.getLeft());
            Long endId = Long.parseLong(idRange.getRight());

            for (Long i = startId; i <= endId; i++) {
                String id = String.valueOf(i);
                if (id.length() % 2 == 1) {
                    continue; // Odd length ids can't be valid'
                }
                String sub1 = id.substring(0, (id.length() / 2));
                String sub2 = id.substring((id.length() / 2));

                if (sub1.equals(sub2)) {
                    sumOfInvalidIds += i;
                }
            }
        }

        return String.valueOf(sumOfInvalidIds);
    }

    @Override
    public String solvePart2() {
        // TODO: Implement part 2 solution
        return "Part 2 not implemented yet";
    }
}

