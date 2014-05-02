package com.tw.mritunjd.marserover;

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

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public void moveForward() {
        if (this.direction == NORTH.getInstance()) {
            this.x_axis += 1;
            return;
        }
        if (this.direction == SOUTH.getInstance()) {
            this.x_axis -= 1;
            return;
        }
        if (this.direction == WEST.getInstance()) {
            this.y_axis -= 1;
            return;
        }
        if (this.direction == EAST.getInstance()) {
            this.y_axis += 1;
            return;
        }
    }
}
