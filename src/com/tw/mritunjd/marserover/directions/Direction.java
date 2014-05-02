package com.tw.mritunjd.marserover.directions;

import com.tw.mritunjd.marserover.Rover;

public interface Direction {
    public void turnLeft(Rover rover);
    public void turnRight(Rover rover);

    void moveForward(Rover rover);
}
