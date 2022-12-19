package com.freyahesketh.adventofcode.solution;

import com.freyahesketh.adventofcode.model.PartSolution;

import java.util.List;

public class Day03 extends Day {

    @Override
    protected int getDay() {
        return 3;
    }

    @Override
    // https://adventofcode.com/2022/day/3
    PartSolution part1(List<String> input) {
        int sum = 0;
        for (String rucksack : input){
            // Store the compartments as 2 Strings utilizing the fact that they are equal in size
            String compartment1 = rucksack.substring(0, rucksack.length()/2);
            String compartment2 = rucksack.substring(rucksack.length()/2);
            // For each item in the compartment
            for (int i = 0; i < compartment1.length(); i++){
                Character item = compartment1.charAt(i);
                // If the second compartment contains the item in the first compartment
                if (compartment2.contains(item.toString())){
                    // Convert the character to an ascii value and then give it the value required in the question
                    if (Character.isUpperCase(item)){ sum += (int) item - 38; }
                    else { sum += (int) item - 96; }
                    // Only 1 item matches per compartment so the loop can be broken
                    break;
                }
            }
        }
        return new PartSolution(1, sum, null);
    }

    @Override
    PartSolution part2(List<String> input) {
        int sum = 0;
        // For each pair of 3 elves in the list
        for (int i = 0; i < input.size();  i += 3){
            String elf1 = input.get(i);
            String elf2 = input.get(i+1);
            String elf3 = input.get(i+2);
            // For each item in the compartment
            for (int x = 0; x < elf1.length(); x++){
                Character item = elf1.charAt(x);
                // If the second and third compartments contains the item in the first compartment
                if (elf2.contains(item.toString()) && elf3.contains(item.toString())){
                    if (Character.isUpperCase(item)){ sum += (int) item - 38; }
                    else { sum += (int) item - 96; }
                    // Only 1 item matches per compartment so the loop can be broken
                    break;
                }
            }
        }
        return new PartSolution(2, sum, null);
    }
}
