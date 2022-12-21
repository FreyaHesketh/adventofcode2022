package com.freyahesketh.adventofcode.solution.day07;

import com.freyahesketh.adventofcode.model.PartSolution;
import com.freyahesketh.adventofcode.solution.Day;

import java.util.ArrayList;
import java.util.List;

public class Day07 extends Day {
    @Override
    protected int getDay() {
        return 7;
    }

    // https://adventofcode.com/2022/day/7
    @Override
    public PartSolution part1(List<String> input) {
        List<Directory> allDirectories = fileTreeCreation(input);
        List<Directory> smallestDirectories = new ArrayList<>();
        // For each directory, calculate its size and add it to a new list is its size is < 100000
        for (Directory directory : allDirectories) {
            directory.calculateSize();
            if (directory.getTotalSize() < 100000) {
                smallestDirectories.add(directory);
            }
        }
        int sum = 0;
        // Calculate the total size of all directories with a size < 100000
        for (Directory directory : smallestDirectories) {
            sum += directory.getTotalSize();
        }
        return new PartSolution(1, sum, null);
    }

    @Override
    public PartSolution part2(List<String> input) {
        List<Directory> allDirectories = fileTreeCreation(input);
        for (Directory directory : allDirectories) {
            directory.calculateSize();
        }
        // The total size is equal to the size of the root directory
        int totalSize = allDirectories.get(0).getTotalSize();
        // The size to find is equal to the space required - the size remaining
        int sizeToFind = 30000000 - (70000000 - totalSize);
        // Creating a list to avoid instantiating an empty directory
        List<Directory> potentialDirectories = new ArrayList<>();
        for (Directory directory : allDirectories) {
            if (directory.getTotalSize() > sizeToFind){
                // If it's the first instance where directory.getTotalSize() > sizeToFind
                if (potentialDirectories.isEmpty()){
                    potentialDirectories.add(directory);
                }
                else if (directory.getTotalSize() < potentialDirectories.get(0).getTotalSize()) {
                    potentialDirectories.add(0, directory);
                }
            }
        }
        return new PartSolution(2, potentialDirectories.get(0).getTotalSize(), null);
    }
    
    public List<Directory> fileTreeCreation(List<String> input){
        List<Directory> allDirectories = new ArrayList<>();
        // Create the home directory
        Directory currentDirectory = new Directory(null, "home");
        allDirectories.add(currentDirectory);
        for (String line : input) {
            // If it equals the first line, do nothing 
            if (line.equals("$ cd /")) {

            } else if (line.contains("$ cd")) {
                // If the command is to move out one directory
                if (line.contains("..")) {
                    // The parent of the current directory becomes the current directory
                    currentDirectory = currentDirectory.getParent();
                    // If the command to is to move in one level     
                } else {
                    // For each directory in the current directory (as directory name is not unique)
                    for (Directory directory : currentDirectory.getChildren()){
                        // If the command includes the name of the target directory, that becomes the current directory
                        if (directory.getName().equals(line.substring(5))){
                            currentDirectory = directory;
                        }
                    }
                }
                // Else if the String is the "ls" command then do nothing    
            } else if (line.contains("$")) {

                // If it's a new directory, create a new directory with the given name and the parent as the current directory    
            } else if (line.contains("dir")) {
                Directory directory = new Directory(currentDirectory, line.substring(4));
                currentDirectory.addChild(directory);
                allDirectories.add(directory);
                // Else if it is a new, create a new file with the given name and sizes and add it to the current directory     
            } else {
                String fileName = line.substring(line.indexOf(' ') + 1);
                int fileSize = Integer.valueOf(line.substring(0, line.indexOf(' ')));
                File file = new File(currentDirectory, fileName, fileSize);
                currentDirectory.addFile(file);
            }
        }
        return allDirectories;
    }
}
