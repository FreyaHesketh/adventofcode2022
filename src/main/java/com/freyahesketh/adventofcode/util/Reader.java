package com.freyahesketh.adventofcode.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public static String INPUT_FILE_PATH = "src/main/resources/input";

    public static String inputFileName(int day) {
        return INPUT_FILE_PATH + String.format("/day%02d.txt", day);
    }

    public static List<String> readFile(String filename) {
        List<String> results = new ArrayList<>();
        try {
            BufferedReader br =  new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            while (line != null) {
                results.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            e.printStackTrace();
        }catch (IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        }
        return results;
    }
}
