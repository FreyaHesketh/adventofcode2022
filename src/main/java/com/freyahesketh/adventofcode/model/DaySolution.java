package com.freyahesketh.adventofcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DaySolution {
    private Integer dayNumber;
    private PartSolution part1Solution;
    private PartSolution part2Solution;

}
