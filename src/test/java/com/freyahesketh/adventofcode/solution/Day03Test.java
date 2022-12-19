package com.freyahesketh.adventofcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day03Test {
    private static List<String> INPUT = List.of(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw"
    );

    private Day03 day03;

    @BeforeEach
    void setUp() {
        day03 = new Day03();
    }

    @Test
    void part1() {
        assertEquals(157, day03.part1(INPUT).getIntSolution());
    }

    @Test
    void part2() {
        assertEquals(70, day03.part2(INPUT).getIntSolution());
    }

}
