package com.tw.mritunjd.marserover.core;

import com.tw.mritunjd.marserover.directions.*;

import java.util.HashMap;
import java.util.Map;

public class Rover implements Movable {
    private Direction direction;
    private Coordinate position;
    private Map<Character, Direction> directionMap = new HashMap<>();

    private void setDirections() {
        directionMap.put('N', NORTH.getInstance());
        directionMap.put('S', SOUTH.getInstance());
        directionMap.put('E', EAST.getInstance());
        directionMap.put('W', WEST.getInstance());
    }

    public Rover(Coordinate coordinate, char dirSymbol) {
        setDirections();
        this.direction = directionMap.get(dirSymbol);
        this.position = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        return direction.equals(rover.direction) && position.equals(rover.position);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "direction=" + direction +
                ", position=" + position +
                '}';
    }

    public void turnLeft() {
        this.direction = this.direction.getLeftDirection();
    }

    public void turnRight() {
        this.direction = this.direction.getRightDirection();
    }

    public void moveForward() {
        this.position = this.direction.getNextCoordinates(this.position);
    }

    public String getLocation() {
        StringBuilder location = new StringBuilder("");
        location.append(this.position.getX_axis()).append(" ").append(this.position.getY_axis()).append(" ");
        String directionSymbol = this.direction.toString();
        location.append(directionSymbol);
        return location.toString();
    }
}
