package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.NORTH;
import com.tw.mritunjd.marserover.SOUTH;

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
