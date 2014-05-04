package com.tw.mritunjd.marserover;

import com.tw.mritunjd.marserover.factory.MarsRoverFactory;


public class Plateau {
    private Coordinates lowerLeftCoordinate;
    private Coordinates upperRightCoordinates;
    private Rover rover;
    private MarsRoverFactory factory;

    public Plateau(int max_X_Axis, int max_Y_Axis, MarsRoverFactory factory) {
        this.lowerLeftCoordinate = new Coordinates(0, 0);
        this.upperRightCoordinates = new Coordinates(max_X_Axis, max_Y_Axis);
        this.factory = factory;
    }

    public void initRover(int position_X_Axis, int position_Y_Axis, Character directionSymbol) {
        rover = factory.createRover(position_X_Axis, position_Y_Axis, directionSymbol);
    }

    public void explorePlateau(String instructionSeries) {
        for (int i = 0; i < instructionSeries.length(); i++) {
            Character instruction = instructionSeries.charAt(i);
            if (instruction == 'L')
                rover.turnLeft();
            else if (instruction == 'R')
                rover.turnRight();
            else if (instruction == 'M')
                rover.moveForward();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plateau plateau = (Plateau) o;

        if (rover != null ? !rover.equals(plateau.rover) : plateau.rover != null) return false;

        return lowerLeftCoordinate.equals(plateau.lowerLeftCoordinate)
                && upperRightCoordinates.equals(plateau.upperRightCoordinates);

    }
}
