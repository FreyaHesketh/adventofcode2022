package com.freyahesketh.adventofcode.solution.day07;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class File {
    
    private Directory directory;
    private String name;
    private int size;
    
    public int getSize(){
        return size;
    }
    
}
