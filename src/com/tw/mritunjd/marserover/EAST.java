package com.tw.mritunjd.marserover;

public class EAST implements Direction {
    private static final Direction east = new EAST();

    public static Direction getInstance() {
        return east;
    }

    public EAST() {
    }

    @Override
    public Direction turnLeft() {
        return NORTH.getInstance();
    }

    @Override
    public Direction turnRight() {
        return SOUTH.getInstance();
    }
}
