package com.solutions.year2025.day6;

import com.Solution;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Day06 extends Solution {
    @Override
    public String solvePart1() {
        List<List<String>> twoDimensionalInput = new ArrayList<>();
        List<Integer> completelyEmptyRowIndices = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < this.lines[0].length(); rowIndex++) {
            List<String> row = new ArrayList<>();

            for (String column : this.lines) {
                row.add(String.valueOf(column.charAt(rowIndex)));
            }
            if (row.stream().allMatch(cell -> cell.equals(" "))) {
                completelyEmptyRowIndices.add(rowIndex);
            }
        }
        completelyEmptyRowIndices.add(this.lines[0].length());

        // Now split the columns on all empty rows
        for (int columnIndex = 0; columnIndex < this.lines.length; columnIndex++) {
            List<String> column = new ArrayList<>();
            for (int emptyRowIndex = 0; emptyRowIndex < completelyEmptyRowIndices.size(); emptyRowIndex++) {
                int startIndex = emptyRowIndex == 0 ? 0 : completelyEmptyRowIndices.get(emptyRowIndex - 1);
                String rowValue;
                if (startIndex == completelyEmptyRowIndices.getLast()) {
                    rowValue = this.lines[emptyRowIndex].substring(startIndex, this.lines[0].length() - 1).strip();
                    column.add(rowValue);
                    continue;

                }
                int nextEmptyRowIndex = completelyEmptyRowIndices.get(emptyRowIndex);
                rowValue = this.lines[columnIndex].substring(startIndex, nextEmptyRowIndex).strip();
                column.add(rowValue);
            }
            twoDimensionalInput.add(column);
        }

        Long total = 0L;
        for (int rowIndex = 0; rowIndex < twoDimensionalInput.getFirst().size(); rowIndex++) {
            List<String> row = new ArrayList<>();
            for (List<String> strings : twoDimensionalInput) {
                row.add(strings.get(rowIndex));
            }
            String operator = row.getLast();
            row.removeLast();

            if ("+".equals(operator)) {
                total += row.stream().mapToLong(Long::parseLong).sum();
            }
            if ("*".equals(operator)) {
                total += row.stream().mapToLong(Long::parseLong).reduce(1, (a, b) -> a * b);
            }


        }


        return Long.toString(total);
    }

    @Override
    public String solvePart2() {
        List<List<String>> twoDimensionalInput = new ArrayList<>();
        List<Integer> completelyEmptyRowIndices = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < this.lines[0].length(); rowIndex++) {
            List<String> row = new ArrayList<>();

            for (String column : this.lines) {
                row.add(String.valueOf(column.charAt(rowIndex)));
            }
            if (row.stream().allMatch(cell -> cell.equals(" "))) {
                completelyEmptyRowIndices.add(rowIndex);
            }
        }
        completelyEmptyRowIndices.add(this.lines[0].length());

        // Now split the columns on all empty rows
        for (int columnIndex = 0; columnIndex < this.lines.length; columnIndex++) {
            List<String> column = new ArrayList<>();
            for (int emptyRowIndex = 0; emptyRowIndex < completelyEmptyRowIndices.size(); emptyRowIndex++) {
                int startIndex = emptyRowIndex == 0 ? 0 : completelyEmptyRowIndices.get(emptyRowIndex - 1);
                String rowValue;
                if (startIndex == completelyEmptyRowIndices.getLast()) {
                    rowValue = this.lines[emptyRowIndex].substring(startIndex, this.lines[0].length() - 1); // Remove strip for part2
                    column.add(rowValue);
                    continue;

                }
                int nextEmptyRowIndex = completelyEmptyRowIndices.get(emptyRowIndex);
                rowValue = this.lines[columnIndex].substring(startIndex, nextEmptyRowIndex); // Remove strip for part2
                column.add(rowValue);
            }
            twoDimensionalInput.add(column);
        }

        Long total = 0L;
        for (int rowIndex = 0; rowIndex < twoDimensionalInput.getFirst().size(); rowIndex++) {
            List<String> row = new ArrayList<>();
            for (List<String> strings : twoDimensionalInput) {
                row.add(strings.get(rowIndex));
            }
            String operator = row.getLast().strip();
            row.removeLast();

            // Map row to part2 requirements:
            List<String> part2MappedRow = new ArrayList<>();
            for (int i = row.getFirst().length() - 1; i >= 0; i--) {
                StringBuilder num = new StringBuilder();
                for (String cell : row) {
                    num.append(cell.charAt(i));
                }
                part2MappedRow.add(num.toString().strip());
            }

            if ("+".equals(operator)) {
                total += part2MappedRow.stream().filter(StringUtils::isNotBlank).mapToLong(Long::parseLong).sum();
            }
            if ("*".equals(operator)) {
                total += part2MappedRow.stream().filter(StringUtils::isNotBlank).mapToLong(Long::parseLong).reduce(1, (a, b) -> a * b);
            }


        }


        return Long.toString(total);
    }
}
