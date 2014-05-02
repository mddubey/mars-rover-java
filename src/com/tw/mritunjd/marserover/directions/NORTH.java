package com.tw.mritunjd.marserover.directions;

public class NORTH implements Direction {
    private static final Direction north = new NORTH();

    public static Direction getInstance() {
        return north;
    }

    public NORTH() {
    }

    @Override
    public Direction turnLeft() {
        return WEST.getInstance();
    }

    @Override
    public Direction turnRight() {
        return EAST.getInstance();
    }
}
