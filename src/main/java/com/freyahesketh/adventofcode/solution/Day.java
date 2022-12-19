package com.freyahesketh.adventofcode.solution;

import com.freyahesketh.adventofcode.model.DaySolution;
import com.freyahesketh.adventofcode.model.PartSolution;
import lombok.Data;

import java.util.List;

public abstract class Day {

    protected abstract int getDay();

    public DaySolution daySolution(List<String> input) {
        return new DaySolution(getDay(), part1(input), part2(input));
    }

    abstract PartSolution part1(List<String> input);

    abstract PartSolution part2(List<String> input);
}
