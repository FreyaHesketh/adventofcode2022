package com.freyahesketh.adventofcode.solution;

import com.freyahesketh.adventofcode.model.PartSolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 extends Day {

    @Override
    protected int getDay() {
        return 1;
    }

    @Override
    // https://adventofcode.com/2022/day/1        
    // Find the calories of the elf with the highest total number of calories
    PartSolution part1(List<String> input) {
        return new PartSolution(1, Collections.max(getCalorieSum(input)), null);
    }

    @Override
    // Find the calories of the three elves with the highest total number of calories
    PartSolution part2(List<String> input) {
        // Return a list of the sums of the calories 
        ArrayList<Integer> calories = getCalorieSum(input);
        // Sort the list in descending order
        Collections.sort(calories, Collections.reverseOrder());
        // Create a new list of the highest 3 elves
        ArrayList<Integer> highestThree = new ArrayList<>(calories.subList(0,3));
        int topElves = 0;
        // Sum the total number of calories for the 3 elves
        for (int value : highestThree){
            topElves += value;
        }
        return new PartSolution(1,topElves, null);
    }

    // Given the input, calculate and return a list of summed calories for each elf
    private ArrayList<Integer> getCalorieSum(List<String> input){
        ArrayList<Integer> calories = new ArrayList<>();
        int calorieSum = 0;
        // Sum the calories if the String is not empty
        for (int i = 0; i < input.size(); i++){
            if (!input.get(i).isEmpty()){
                calorieSum += Integer.parseInt(input.get(i));
            }
            // If it is empty, add the sum to the list and reset the sum
            else {
                calories.add(calorieSum);
                calorieSum = 0;
            }
        }
        // If the file does not end on an empty String, add the final value to the list
        if (calorieSum != 0){calories.add(calorieSum);}
        return calories;
    }
}
