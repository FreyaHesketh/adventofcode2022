package com.freyahesketh.adventofcode.solution;

import com.freyahesketh.adventofcode.solution.day07.Day07;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day07Test {
    private static List<String> INPUT = List.of(
            "$ cd /",
                     "$ ls",
            "dir a",
            "14848514 b.txt",
            "8504156 c.dat",
            "dir d",
            "$ cd a",
            "$ ls",
            "dir e",
            "29116 f",
            "2557 g",
            "62596 h.lst",
            "$ cd e",
            "$ ls",
            "584 i",
            "$ cd ..",
            "$ cd ..",
            "$ cd d",
            "$ ls",
            "4060174 j",
            "8033020 d.log",
            "5626152 d.ext",
            "7214296 k"
    );
    
    private Day07 day07;

    @BeforeEach
    void setUp() {
        day07 = new Day07();
    }

    @Test
    void part1() {
        assertEquals(95437, day07.part1(INPUT).getIntSolution());
    }

    @Test
    void part2() {
        assertEquals(24933642, day07.part2(INPUT).getIntSolution());
    }

}
