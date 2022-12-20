package com.freyahesketh.adventofcode.solution;

import com.freyahesketh.adventofcode.model.PartSolution;

import java.util.List;

public class Day02 extends Day {

    @Override
    protected int getDay() {
        return 2;
    }

    @Override
    // https://adventofcode.com/2022/day/2        
    // If Y, rock, has a score of 1, X, paper, has a score of 2 and Y, scissors, has a score of 3
    // and if winning gives 6 points, drawing 3 and losing 0 - what is the total score?
    public PartSolution part1(List<String> input) {
        int score = 0;
        for (String game : input){
            // If I play rock
            if (game.contains("X")) {score += 1;}
            // If I play paper
            else if (game.contains("Y")){score += 2;}
            // If I play scissors
            else {score += 3;}
            // If I draw
            if (game.equals("A X") || game.equals("B Y") || game.equals("C Z")){score += 3;}
            //If I win
            else if (game.equals("C X") || game.equals("A Y") || game.equals("B Z")){score += 6;}
        }
        return new PartSolution(1, score, null);
    }

    @Override
    // If A is rock, B is paper and C scissors and X means I need to lose, Y draw and Z win what is the total score?
    public PartSolution part2(List<String> input) {
        int score = 0;
        for (String game : input){
            // If I draw
            if (game.contains("Y")) {score += 3;}
            // If I win
            else if (game.contains("Z")){score += 6;}
            // If I need to play rock to get the needed result
            if (game.equals("A Y") || game.equals("B X") || game.equals("C Z")){score += 1;}
            // If I need to play paper to get the needed result
            else if (game.equals("A Z") || game.equals("B Y") || game.equals("C X")){score += 2;}
            // If I need to play scissors to get the needed result
            else {score += 3;}
            }
        return new PartSolution(2,score,null);
    }
}
