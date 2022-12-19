package com.freyahesketh.adventofcode;

import com.freyahesketh.adventofcode.model.DaySolution;
import com.freyahesketh.adventofcode.util.Reader;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        runDaySolution(1,true);
    }

    private static void runDaySolution(int day, boolean isInt){
        RestTemplate restTemplate = new RestTemplate();
        List<String> input = Reader.readFile(Reader.inputFileName(day));
        var response = restTemplate.postForEntity(URI.create("http://localhost:8080/day/"+day), input, DaySolution.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            DaySolution result = response.getBody();
            if (isInt){
                System.out.println("Day " + day + " Part 1 Solution = " + result.getPart1Solution().getIntSolution());
                System.out.println("Day " + day + " Part 2 Solution = " + result.getPart2Solution().getIntSolution());
            }
            else {
                System.out.println("Day " + day + " Part 1 Solution = " + result.getPart1Solution().getStringSolution());
                System.out.println("Day " + day + " Part 2 Solution = " + result.getPart2Solution().getStringSolution());
            }
        } else {
            System.out.println("Oh no!");
        }
    }
}
