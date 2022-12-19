package com.freyahesketh.adventofcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day05Test {
    private static List<String> INPUT = List.of(
            "    [D]    ",
            "[N] [C]    ",
            "[Z] [M] [P]",
            " 1   2   3 ",
            "",
            "move 1 from 2 to 1",
            "move 3 from 1 to 3",
            "move 2 from 2 to 1",
            "move 1 from 1 to 2"
    );


    private Day05 day05;

    @BeforeEach
    void setUp() {
        day05 = new Day05();
    }

    @Test
    void part1() {
        assertEquals("CMZ", day05.part1(INPUT).getStringSolution());
    }

    @Test
    void part2() {
        assertEquals("MCD", day05.part2(INPUT).getStringSolution());
    }

}
