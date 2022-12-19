package com.freyahesketh.adventofcode.solution;

import com.freyahesketh.adventofcode.model.PartSolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day05 extends Day {

    @Override
    protected int getDay() {return 5;}

    @Override
    // https://adventofcode.com/2022/day/5
    PartSolution part1(List<String> input) {
        String answer = "";
        ArrayList<LinkedList> stackList = stringReader(input, 0);
        // Construct the answer String by taking the first crate of each stack
        for (Queue finalStack : stackList){
            answer = answer + finalStack.peek();
        }
        return new PartSolution(1, null, answer);
    }

    @Override
    PartSolution part2(List<String> input) {
        String answer = "";
        ArrayList<LinkedList> stackList = stringReader(input, 1);
        // Construct the answer String by taking the first crate of each stack
        for (Queue finalStack : stackList){
            answer = answer + finalStack.peek();
        }
        return new PartSolution(2, null, answer);
    }
    
    private ArrayList<LinkedList> stringReader(List<String> input, int instruction){
        ArrayList<LinkedList> stackList = new ArrayList<>();
        // Using LinkedLists as they follow FIFO
        LinkedList<Integer> moveQueue = new LinkedList<>();
        LinkedList<Integer> fromQueue = new LinkedList<>();
        LinkedList<Integer> toQueue = new LinkedList<>();
        // Create a pattern to match the input string
        Pattern p = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
        // Initialise the list of stacks by taking the length of the first string and dividing by 4 as the structure is
        // consistent. For e.g., a length of 11 will mean 4 stacks will be required
        for (int z = 0; z < (input.get(0).length() + 1)/4; z++){
            stackList.add(new LinkedList());
        }
        // Main loop iterating through each line in the file
        for (int i = 0; i < input.size(); i++){
            String line = input.get(i);
            // Reading in the first part of the file with the starting structure of the stacks
            // All other lines are either empty, have a '1' at position 1 or 'o' at position 1
            if (line.charAt(1) != '1' && line.charAt(1) != 'o'){
                // The location of the crate is consistent throughout the structure so each position where a crate 
                // could exist can be checked. The location in the String is used to identify which stack it should be
                // added to.
                for (int x = 0; x < (line.length() + 1)/4; x++){
                    Character item = line.charAt(1 + x * 4);
                    // If there is a crate at this location, at it to the stack
                    if (!item.equals(' ')){
                        stackList.get(x).add(item);
                    }
                }
            }
            // If it's the empty string skip the line
            else if (line.charAt(0) != 'm'){ i++; }
            // If it's the final section of instructions
            else {
                Matcher m = p.matcher(input.get(i));
                // Extract the three numbers from the input string
                m.find();
                int move = Integer.parseInt(m.group(1));
                int from = Integer.parseInt(m.group(2)) - 1;
                int to = Integer.parseInt(m.group(3)) - 1;
                moveQueue.add(move);
                fromQueue.add(from);
                toQueue.add(to);
            }
        }
        // Iterate through the list of instructions
        for (int y = 0; y < moveQueue.size(); y++){
            // If it's part 1
            if (instruction == 0){
                // For the number of moves required by the instructions, move the crate from one stack
                for(int z = 0; z < moveQueue.get(y); z++){
                    stackList.get(toQueue.get(y)).addFirst(stackList.get(fromQueue.get(y)).remove());
                }
            }
            // If it's part 2
            else {
                // For the number of moves required by the instructions, move the number of crates specified while
                // keeping them in order
                for  (int a = moveQueue.get(y); a > 0; a-- ){
                    // Add them in reverse order in order to keep the original order of the crates
                    stackList.get(toQueue.get(y)).addFirst(stackList.get(fromQueue.get(y)).get(a - 1));
                    stackList.get(fromQueue.get(y)).remove(a - 1);
                }
            }
        }
        return stackList;
    }
}
