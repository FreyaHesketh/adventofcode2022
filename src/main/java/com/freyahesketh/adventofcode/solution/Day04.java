package com.freyahesketh.adventofcode.solution;

import com.freyahesketh.adventofcode.model.PartSolution;

import java.util.List;

public class Day04 extends Day {

    @Override
    protected int getDay() {return 4;}

    @Override
    // https://adventofcode.com/2022/day/4
    public PartSolution part1(List<String> input) {
        int sumOfPairs = 0;
        for (String pair : input){
            // The first elf in the pair
            String pair1 = pair.substring(0, pair.indexOf(","));
            // The second elf in the pair
            String pair2 = pair.substring(pair.indexOf(",") + 1);
            // The first value for the first elf
            int a = Integer.valueOf(pair1.substring(0, pair1.indexOf("-")));
            // The second value for the first elf
            int b = Integer.valueOf(pair1.substring(pair1.indexOf("-") + 1));
            // The first value for the second elf
            int c = Integer.valueOf(pair2.substring(0, pair2.indexOf("-")));
            // The second value for the second elf
            int d = Integer.valueOf(pair2.substring(pair2.indexOf("-") + 1));
            // If either elf's zones are encompassed entirely within the second's
            if (a >= c && b <= d || c >= a && d <= b) { sumOfPairs++; }
        }
        return new PartSolution(1, sumOfPairs, null);
    }

    @Override
    public PartSolution part2(List<String> input) {
        int sumOfPairs = 0;
        for (String pair : input){
            // The first elf in the pair
            String pair1 = pair.substring(0, pair.indexOf(","));
            // The second elf in the pair
            String pair2 = pair.substring(pair.indexOf(",") + 1);
            // The first value for the first elf
            int a = Integer.valueOf(pair1.substring(0, pair1.indexOf("-")));
            // The second value for the first elf
            int b = Integer.valueOf(pair1.substring(pair1.indexOf("-") + 1));
            // The first value for the second elf
            int c = Integer.valueOf(pair2.substring(0, pair2.indexOf("-")));
            // The second value for the second elf
            int d = Integer.valueOf(pair2.substring(pair2.indexOf("-") + 1));
            // If either elf's zones are encompassed entirely or partly within the second
            if (b >= c && a <= d || a <= d && b >= d) { sumOfPairs++; }
        }
        return new PartSolution(1, sumOfPairs, null);
    }
}
