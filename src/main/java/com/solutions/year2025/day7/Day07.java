package com.solutions.year2025.day7;

import com.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day07 extends Solution {

    @Override
    public String solvePart1() {
        List<List<String>> twoDimensionalInput = new ArrayList<>();
        for (String line : this.lines) {
            twoDimensionalInput.add(List.of(line.split("")));
        }
        Set<Integer> beamIndices = new HashSet<>();
        beamIndices.add(this.lines[0].indexOf("S")); // S is Starting point of beam
        int totalSplits = 0;

        for (int columnIndex = 1; columnIndex < twoDimensionalInput.size(); columnIndex++) {
            List<String> column = twoDimensionalInput.get(columnIndex);
            // find all occurences of splitters (^) in columns a beam reaches
            Set<Integer> splitterIndices = new HashSet<>();
            for (int rowIndex = 0; rowIndex < column.size(); rowIndex++) {
                if (column.get(rowIndex).equals("^") && beamIndices.contains(rowIndex)) {
                    splitterIndices.add(rowIndex);
                }
            }
            if (splitterIndices.isEmpty()) {
                continue;
            }

            Set<Integer> splittedBeamIndices = new HashSet<>();
            for (Integer split : splitterIndices) {
                splittedBeamIndices.add(split - 1);
                splittedBeamIndices.add(split + 1);
            }
            totalSplits += splitterIndices.size();
            splittedBeamIndices.addAll(beamIndices.stream().filter(index -> !splitterIndices.contains(index)).collect(Collectors.toSet()));
            beamIndices = splittedBeamIndices;
        }

        return String.valueOf(totalSplits);
    }

    @Override
    public String solvePart2() {
//        List<List<String>> twoDimensionalInput = new ArrayList<>();
//        for (String line : this.lines) {
//            twoDimensionalInput.add(List.of(line.split("")));
//        }
//        HashMap<Integer, Integer> beamIndicesToSplitEncounters = new HashMap<>();
//        beamIndicesToSplitEncounters.put(this.lines[0].indexOf("S"), 0); // S is Starting point of beam
//        Long timeLines = 0L;
//
//        for (int columnIndex = 1; columnIndex < twoDimensionalInput.size(); columnIndex++) {
//            List<String> column = twoDimensionalInput.get(columnIndex);
//            // find all occurences of splitters (^) in columns a beam reaches
//            Set<Integer> splitterIndices = new HashSet<>();
//            for (int rowIndex = 0; rowIndex < column.size(); rowIndex++) {
//                if (column.get(rowIndex).equals("^") && beamIndicesToSplitEncounters.containsKey(rowIndex)) {
//                    splitterIndices.add(rowIndex);
//                    beamIndicesToSplitEncounters.put(rowIndex, beamIndicesToSplitEncounters.get(rowIndex) + 1);
//                }
//            }
//            if (splitterIndices.isEmpty()) {
//                continue;
//            }
//
//            Set<Integer> splittedBeamIndices = new HashSet<>();
//            for (Integer split : splitterIndices) {
//                if (splittedBeamIndices.add(split - 1)) {
//                    //timeLines++;
//                }
//                if (splittedBeamIndices.add(split + 1)) {
//                    //timeLines++;
//                }
//            }
//
//            splittedBeamIndices.addAll(beamIndicesToSplitEncounters.keySet().stream().filter(index -> !splitterIndices.contains(index)).collect(Collectors.toSet()));
//
//            beamIndices = splittedBeamIndices;
//        }
//
//        return String.valueOf(timeLines);
        return "";
    }
}
