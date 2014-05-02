package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.Rover;

public class EAST implements Direction {
    private static final Direction east = new EAST();

    public static Direction getInstance() {
        return east;
    }

    public EAST() {
    }

    @Override
    public void turnLeft(Rover rover) {
        rover.setDirection(NORTH.getInstance());
    }

    @Override
    public void turnRight(Rover rover) {
        rover.setDirection(SOUTH.getInstance());
    }

    @Override
    public void moveForward(Rover rover) {
        rover.changeX_axisAfterMove(1);
    }
}
