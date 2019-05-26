package com.avaj.simulation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Writer{
    public static List<String> lines = new ArrayList<String>();
    public static void writeLines(String line) {
        lines.add(line);
    }
    public static void printLines() {
        String filename = "simulation.txt";
        try (PrintWriter out = new PrintWriter(filename)) {
            for (String s : lines) {
                out.print(s + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
