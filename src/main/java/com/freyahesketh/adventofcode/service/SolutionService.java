package com.freyahesketh.adventofcode.service;

import com.freyahesketh.adventofcode.model.DaySolution;
import com.freyahesketh.adventofcode.model.PartSolution;
import com.freyahesketh.adventofcode.solution.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionService {

    public DaySolution getDaySolution(int dayNumber, List<String> input) {
        Day day = getDay(dayNumber);
        try {
            return day.daySolution(input);
        } catch (Exception e) {
            System.out.println("The solution code for day " + dayNumber + " threw an error: " + e.getMessage());
            throw e;
        }
    }

    public PartSolution getPartSolution(int dayNumber, int partNumber, List<String> input) {
        DaySolution daySolution = getDaySolution(dayNumber, input);
        return partNumber == 1 ? daySolution.getPart1Solution() : daySolution.getPart2Solution();
    }

    private Day getDay(int dayNumber) {
        return switch (dayNumber) {
            case 1 -> new Day01();
            case 2 -> new Day02();
            default -> null;
        };
    }
}
