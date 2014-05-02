package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.WEST;

public class SOUTH implements Direction {
    private static final Direction south = new SOUTH();

    public static Direction getInstance() {
        return south;
    }

    private SOUTH() {
    }

    @Override
    public Direction turnLeft() {
        return EAST.getInstance();
    }

    @Override
    public Direction turnRight() {
        return WEST.getInstance();
    }
}
