package com.freyahesketh.adventofcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test {
    private static List<String> INPUT = List.of(
            "A Y",
            "B X",
            "C Z"
    );

    private Day02 day02;

    @BeforeEach
    void setUp() {
        day02 = new Day02();
    }

    @Test
    void part1() {
        assertEquals(15, day02.part1(INPUT).getIntSolution());
    }

    @Test
    void part2() {
        assertEquals(12, day02.part2(INPUT).getIntSolution());
    }

}
