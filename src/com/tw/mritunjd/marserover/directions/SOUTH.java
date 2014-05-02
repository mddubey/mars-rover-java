package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.Rover;

public class SOUTH implements Direction {
    private static final Direction south = new SOUTH();

    public static Direction getInstance() {
        return south;
    }

    private SOUTH() {
    }

    @Override
    public void turnLeft(Rover rover) {
        rover.setDirection(EAST.getInstance());
    }

    @Override
    public void turnRight(Rover rover) {
        rover.setDirection(WEST.getInstance());
    }

    @Override
    public void moveForward(Rover rover) {
        rover.changeY_axisAfterMove(-1);
    }
}
