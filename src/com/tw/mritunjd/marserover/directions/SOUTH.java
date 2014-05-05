package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.Coordinate;

public class SOUTH implements Direction {
    private static final Direction south = new SOUTH();

    public static Direction getInstance() {
        return south;
    }

    private SOUTH() {
    }

    @Override
    public String toString() {
        return "S";
    }

    @Override
    public Direction getLeftDirection() {
        return EAST.getInstance();
    }

    @Override
    public Direction getRightDirection() {
        return WEST.getInstance();
    }

    @Override
    public Coordinate getNextCoordinates(Coordinate coordinate) {
        int x_axis = coordinate.getX_axis();
        int y_axis = coordinate.getY_axis();
        Coordinate nextCoordinate = new Coordinate(x_axis, y_axis - 1);
        return nextCoordinate;
    }
}
