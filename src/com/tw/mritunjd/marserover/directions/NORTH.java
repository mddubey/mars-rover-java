package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.Coordinate;

public class NORTH implements Direction {
    private static final Direction north = new NORTH();

    public static Direction getInstance() {
        return north;
    }

    private NORTH() {
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public Direction getLeftDirection() {
        return WEST.getInstance();
    }

    @Override
    public Direction getRightDirection() {
        return EAST.getInstance();
    }

    @Override
    public Coordinate getNextCoordinates(Coordinate coordinate) {
        int x_axis = coordinate.getX_axis();
        int y_axis = coordinate.getY_axis();
        Coordinate nextCoordinate = new Coordinate(x_axis, y_axis + 1);
        return nextCoordinate;
    }
}
