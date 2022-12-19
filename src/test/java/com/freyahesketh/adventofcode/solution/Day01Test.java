package com.freyahesketh.adventofcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    private static List<String> INPUT = List.of(
            "1000",
            "2000",
            "3000",
            "",
            "4000",
            "",
            "5000",
            "6000",
            "",
            "7000",
            "8000",
            "9000",
            "",
            "10000"
    );

    private Day01 day01;

    @BeforeEach
    void setUp() {
        day01 = new Day01();
    }

    @Test
    void part1() {
        assertEquals(24000, day01.part1(INPUT).getIntSolution());
    }

    @Test
    void part2() {
        assertEquals(45000, day01.part2(INPUT).getIntSolution());
    }
}
