package com.freyahesketh.adventofcode.controller;

import com.freyahesketh.adventofcode.model.DaySolution;
import com.freyahesketh.adventofcode.model.PartSolution;
import com.freyahesketh.adventofcode.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdventController {

    @Autowired
    private SolutionService solutionService;

    @PostMapping("/day/{day}")
    public DaySolution getDaySolution(@PathVariable int day, @RequestBody List<String> input) {
        return solutionService.getDaySolution(day, input);
    }

    @PostMapping("/day/{day}/part/{part}")
    public PartSolution getPartSolution(@PathVariable int day, @PathVariable int part, @RequestBody List<String> input) {
        return solutionService.getPartSolution(day, part, input);
    }
}
