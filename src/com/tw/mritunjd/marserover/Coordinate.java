package com.tw.mritunjd.marserover;

public class Coordinate {
    private int x_axis;
    private int y_axis;

    public Coordinate(int x, int y) {
        this.x_axis = x;
        this.y_axis = y;
    }

    public int getX_axis() {
        return x_axis;
    }

    public int getY_axis() {
        return y_axis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate coordinate = (Coordinate) o;

        return x_axis == coordinate.x_axis && y_axis == coordinate.y_axis;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x_axis=" + x_axis +
                ", y_axis=" + y_axis +
                '}';
    }
}
