package com.tw.mritunjd.marserover.cli;

import com.tw.mritunjd.marserover.core.Coordinate;
import com.tw.mritunjd.marserover.core.Plateau;
import com.tw.mritunjd.marserover.factory.MarsRoverFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interpreter {
    private Plateau plateau;
    private MarsRoverFactory factory;

    public Interpreter(MarsRoverFactory factory) {
        this.factory = factory;
    }

    public List<String> getInput() {
        Scanner scanner = new Scanner(System.in);
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

    public void performOperationOnInput(List<String> inputs) {
        String[] upperRightCoordinates = inputs.get(0).split(" ");
        int max_x_axis = Integer.parseInt(upperRightCoordinates[0]);
        int max_y_axis = Integer.parseInt(upperRightCoordinates[1]);
        plateau = this.factory.createPlateau(new Coordinate(max_x_axis, max_y_axis), this.factory);
        int index = 1;
        System.out.println("Location after exploration:--");
        while (index < inputs.size()) {
            String[] initRoverInput = inputs.get(index++).split(" ");
            String movementInstructions = inputs.get(index++);
            int position_x_axis = Integer.parseInt(initRoverInput[0]);
            int position_y_axis = Integer.parseInt(initRoverInput[1]);
            Character directionSymbol = initRoverInput[2].charAt(0);
            plateau.initRover(position_x_axis, position_y_axis, directionSymbol);
            plateau.explorePlateau(movementInstructions);
            String result = plateau.getRoverLocation();
            System.out.println(result);
        }
    }
}
