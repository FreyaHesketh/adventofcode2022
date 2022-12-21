package com.freyahesketh.adventofcode.solution.day07;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    
    private Directory parent;
    private List<File> files;
    private String name;
    private List<Directory> children;
    private int totalSize;
    
    public Directory(Directory parent, String name){
        this.parent = parent;
        this.name = name;
        files = new ArrayList<>();
        children = new ArrayList<>();
    }
    
    public Directory getParent(){
        return parent;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getTotalSize(){
        return totalSize;
    }
    
    public List<Directory> getChildren(){
        return children;
    }
    
    public void addFile(File file){
        files.add(file);
    }
    
    public void addChild(Directory directory){
        children.add(directory);
    }
    
    // Recursively calculates the size of this directory including the size of all its children directories
    public int calculateSize(){
        totalSize = 0;
        for (File file: files){
            totalSize += file.getSize();
        }
        for (Directory directory: children){
            totalSize += directory.calculateSize();
        }
        return totalSize;
    }
}
