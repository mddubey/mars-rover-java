package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.Rover;

public class WEST implements Direction {
    private static final Direction west = new WEST();

    public static Direction getInstance() {
        return west;
    }

    private WEST(){

    }

    @Override
    public void turnLeft(Rover rover) {
        rover.setDirection(SOUTH.getInstance());
    }

    @Override
    public void turnRight(Rover rover) {
        rover.setDirection(NORTH.getInstance());
    }

    @Override
    public void moveForward(Rover rover) {
        rover.changeX_axisAfterMove(-1);
    }

    @Override
    public String toString() {
        return "W";
    }
}
