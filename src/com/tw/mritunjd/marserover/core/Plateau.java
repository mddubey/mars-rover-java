package com.tw.mritunjd.marserover.core;

import com.tw.mritunjd.marserover.factory.MarsRoverFactory;

import java.util.HashMap;
import java.util.Map;

interface MoveAction {
    void makeRoverMoved();
}

public class Plateau {
    private Coordinate lowerLeftCoordinate;
    private Coordinate upperRightCoordinate;
    private Rover rover;
    private MarsRoverFactory factory;

    public Plateau(int max_X_Axis, int max_Y_Axis, MarsRoverFactory factory) {
        this.lowerLeftCoordinate = new Coordinate(0, 0);
        this.upperRightCoordinate = new Coordinate(max_X_Axis, max_Y_Axis);
        this.factory = factory;
    }

    public void initRover(int position_X_Axis, int position_Y_Axis, Character directionSymbol) {
        Coordinate roverPosition = new Coordinate(position_X_Axis, position_Y_Axis);
        rover = factory.createRover(roverPosition, directionSymbol);
    }

    public void explorePlateau(String instructionSeries) {
        Map<Character, MoveAction> instructionMap = new HashMap();
        setMoveActions(instructionMap);

        for (int i = 0; i < instructionSeries.length(); i++) {
            Character instruction = instructionSeries.charAt(i);
            instructionMap.get(instruction).makeRoverMoved();
        }
    }

    private void setMoveActions(Map<Character, MoveAction> instructionMap) {
        MoveAction turnLeftAction = new MoveAction() {
            @Override
            public void makeRoverMoved() {
                rover.turnLeft();
            }
        };

        MoveAction turnRightAction = new MoveAction() {
            @Override
            public void makeRoverMoved() {
                rover.turnRight();
            }
        };

        MoveAction moveForwardAction = new MoveAction() {
            @Override
            public void makeRoverMoved() {
                rover.moveForward();
            }
        };
        instructionMap.put('R', turnRightAction);
        instructionMap.put('L', turnLeftAction);
        instructionMap.put('M', moveForwardAction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plateau plateau = (Plateau) o;

        if (rover != null ? !rover.equals(plateau.rover) : plateau.rover != null) return false;

        return lowerLeftCoordinate.equals(plateau.lowerLeftCoordinate)
                && upperRightCoordinate.equals(plateau.upperRightCoordinate);

    }

    public String getRoverLocation() {
        return this.rover.getLocation();
    }
}