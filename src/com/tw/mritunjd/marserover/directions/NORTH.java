package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.Rover;

public class NORTH implements Direction {
    private static final Direction north = new NORTH();

    public static Direction getInstance() {
        return north;
    }

    private NORTH() {
    }

    @Override
    public void turnLeft(Rover rover) {
        rover.setDirection(WEST.getInstance());
    }

    @Override
    public void turnRight(Rover rover) {
        rover.setDirection(EAST.getInstance());
    }

    @Override
    public void moveForward(Rover rover) {
        rover.changeY_axisAfterMove(1);
    }

    @Override
    public String toString() {
        return "N";
    }
}
