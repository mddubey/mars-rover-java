package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.core.Coordinate;

public interface Direction {
    public Direction getLeftDirection();
    public Direction getRightDirection();

    public Coordinate getNextCoordinates(Coordinate coordinate);
}
