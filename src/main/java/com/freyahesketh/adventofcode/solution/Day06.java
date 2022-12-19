package com.freyahesketh.adventofcode.solution;

import com.freyahesketh.adventofcode.model.PartSolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day06 extends Day {

    @Override
    protected int getDay() {
        return 5;
    }

    @Override
    // https://adventofcode.com/2022/day/6
    PartSolution part1(List<String> input) {
        return new PartSolution(1, uniqueMessage(input.get(0), 4), null);
    }

    @Override
    PartSolution part2(List<String> input) {
        return new PartSolution(2, uniqueMessage(input.get(0), 14), null);
    }
    
    private int uniqueMessage(String input, int messageLength){
        for (int i = 0; i < input.length(); i++){
            String check = String.valueOf(input.charAt(i));
            // For the next messageLength characters of the String
            for (int x = 1; x < messageLength; x++){
                // If check does not contain the next character, add it to check
                if (!check.contains(String.valueOf(input.charAt(i+x)))){
                    check = check + input.charAt(i + x);
                    // If all messageLength characters are unique, return the position of the final character
                    if (x == messageLength-1){
                        return i+x+1;
                    }
                }
                // Else, break the loop and increment i
                else {
                    break;
                }
            }
        }
        // Return 0 if no unique characters are found (should never happen with the given input)
        return 0;
    }
}