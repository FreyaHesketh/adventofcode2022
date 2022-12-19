package com.freyahesketh.adventofcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day06Test {
    private static List<String> INPUT1 = List.of(
            "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
    );
    private static List<String> INPUT2 = List.of(
            "bvwbjplbgvbhsrlpgdmjqwftvncz"
    );
    private static List<String> INPUT3 = List.of(
            "nppdvjthqldpwncqszvftbrmjlhg"
    ); 
    private static List<String> INPUT4 = List.of(
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
    ); 
    private static List<String> INPUT5 = List.of(
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
    );


    private Day06 day06;

    @BeforeEach
    void setUp() {
        day06 = new Day06();
    }

    @Test
    void part1() {
        assertEquals(7, day06.part1(INPUT1).getIntSolution());
        assertEquals(5, day06.part1(INPUT2).getIntSolution());
        assertEquals(6, day06.part1(INPUT3).getIntSolution());
        assertEquals(10, day06.part1(INPUT4).getIntSolution());
        assertEquals(11, day06.part1(INPUT5).getIntSolution());
    }

    @Test
    void part2() {
        assertEquals(19, day06.part2(INPUT1).getIntSolution());
        assertEquals(23, day06.part2(INPUT2).getIntSolution());
        assertEquals(23, day06.part2(INPUT3).getIntSolution());
        assertEquals(29, day06.part2(INPUT4).getIntSolution());
        assertEquals(26, day06.part2(INPUT5).getIntSolution());
    }

}
