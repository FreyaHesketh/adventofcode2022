package com.freyahesketh.adventofcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day04Test {
    private static List<String> INPUT = List.of(
            "2-4,6-8",
            "2-3,4-5",
            "5-7,7-9",
            "2-8,3-7",
            "6-6,4-6",
            "2-6,4-8"
    );

    private Day04 day04;

    @BeforeEach
    void setUp() {
        day04 = new Day04();
    }

    @Test
    void part1() {
        assertEquals(2, day04.part1(INPUT).getIntSolution());
    }

    @Test
    void part2() {
        assertEquals(4, day04.part2(INPUT).getIntSolution());
    }

}
