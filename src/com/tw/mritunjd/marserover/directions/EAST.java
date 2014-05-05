package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.Coordinate;

public class EAST implements Direction {
    private static final Direction east = new EAST();

    public static Direction getInstance() {
        return east;
    }

    private EAST() {
    }

    @Override
    public String toString() {
        return "E";
    }

    @Override
    public Direction getLeftDirection() {
        return NORTH.getInstance();
    }

    @Override
    public Direction getRightDirection() {
        return SOUTH.getInstance();
    }

    @Override
    public Coordinate getNextCoordinates(Coordinate coordinate) {
        int x_axis = coordinate.getX_axis();
        int y_axis = coordinate.getY_axis();
        Coordinate nextCoordinate = new Coordinate(x_axis + 1, y_axis);
        return nextCoordinate;
    }
}
