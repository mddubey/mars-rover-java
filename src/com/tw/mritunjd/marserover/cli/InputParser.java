package com.tw.mritunjd.marserover.cli;

import com.tw.mritunjd.marserover.core.Coordinate;

import java.util.Arrays;

public class InputParser {
    public Coordinate getCoordinatesFromInput(String input) throws RuntimeException {
        String[] inputParts = input.split(" ");
        try {
            int x_Axis = Integer.parseInt(inputParts[0]);
            int y_Axis = Integer.parseInt(inputParts[1]);
            return new Coordinate(x_Axis, y_Axis);
        }catch (NumberFormatException ex){
            throw new NumberFormatException("Inputs must be numbers eg:- 5 5");
        }catch (ArrayIndexOutOfBoundsException ex){
            throw new ArrayIndexOutOfBoundsException("There should be two numbers eg:- 5 5");
        }
    }

    public Character getDirectionSymbolFromInput(String input) {
        String[] inputParts = input.split(" ");
        try {
            Character directionSymbol = inputParts[2].charAt(0);
            if(Arrays.asList('E','W','N','S').indexOf(directionSymbol) == -1)
                throw new IllegalArgumentException("Invalid Direction Symbol");
            return directionSymbol;
        }catch (ArrayIndexOutOfBoundsException ex){
            throw new ArrayIndexOutOfBoundsException("There should be 3 options eg:- 1 2 N");
        }
    }
}
