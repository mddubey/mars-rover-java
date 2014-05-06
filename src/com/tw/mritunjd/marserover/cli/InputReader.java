package com.tw.mritunjd.marserover.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> getInput() {
        System.out.println("Inputs for Plateau and rovers");
        System.out.println("e.g. \n5 5\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\nEND");
        System.out.println("\nEnter your input:--");
        List<String> inputs = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("end"))
                break;
            inputs.add(line);
        }
        return inputs;
    }
}
