package com.tw.mritunjd.marserover;

import com.tw.mritunjd.marserover.directions.*;

import java.util.HashMap;
import java.util.Map;

public class Rover {
    private Direction direction;
    private int x_axis;
    private int y_axis;
    private Map<Character, Direction> directionMap = new HashMap<>();

    private void setDirections() {
        directionMap.put('N', NORTH.getInstance());
        directionMap.put('S', SOUTH.getInstance());
        directionMap.put('E', EAST.getInstance());
        directionMap.put('W', WEST.getInstance());
    }

    public Rover(int x_axis, int y_axis, char dirSymbol) {
        setDirections();
        this.direction = directionMap.get(dirSymbol);
        this.x_axis = x_axis;
        this.y_axis = y_axis;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void changeX_axisAfterMove(int changeInX) {
        this.x_axis = this.x_axis + changeInX;
    }

    public void changeY_axisAfterMove(int changeInY) {
        this.y_axis = this.y_axis + changeInY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (x_axis != rover.x_axis) return false;
        if (y_axis != rover.y_axis) return false;
        if (direction == null || rover.direction == null) return false;
        return direction.equals(rover.direction);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "direction=" + direction +
                ", x_axis=" + x_axis +
                ", y_axis=" + y_axis +
                '}';
    }

    public void turnLeft() {
        this.direction.turnLeft(this);
    }

    public void turnRight() {
        this.direction.turnRight(this);
    }

    public void moveForward() {
        this.direction.moveForward(this);
    }

    public String getLocation() {
        StringBuilder location = new StringBuilder("");
        location.append(this.x_axis).append(" ").append(this.y_axis).append(" ");
        String directionSymbol = this.direction.toString();
        location.append(directionSymbol);
        return location.toString();
    }
}
