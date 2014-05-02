package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.NORTH;

public class WEST implements Direction {
    private static final Direction west = new WEST();

    public static Direction getInstance() {
        return west;
    }

    private WEST(){

    }

    @Override
    public Direction turnLeft() {
        return SOUTH.getInstance();
    }

    @Override
    public Direction turnRight() {
        return NORTH.getInstance();
    }
}
