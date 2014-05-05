package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.Coordinate;

public class WEST implements Direction {
    private static final Direction west = new WEST();

    public static Direction getInstance() {
        return west;
    }

    private WEST(){

    }

    @Override
    public String toString() {
        return "W";
    }

    @Override
    public Direction getLeftDirection() {
        return SOUTH.getInstance();
    }

    @Override
    public Direction getRightDirection() {
        return NORTH.getInstance();
    }

    @Override
    public Coordinate getNextCoordinates(Coordinate coordinate) {
        int x_axis = coordinate.getX_axis();
        int y_axis = coordinate.getY_axis();
        Coordinate nextCoordinate = new Coordinate(x_axis - 1, y_axis);
        return nextCoordinate;
    }
}
