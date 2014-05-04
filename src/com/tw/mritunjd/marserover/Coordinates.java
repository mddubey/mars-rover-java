package com.tw.mritunjd.marserover;

public class Coordinates {
    private int x_axis;
    private int y_axis;

    public Coordinates(int x, int y) {
        this.x_axis = x;
        this.y_axis = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates coordinate = (Coordinates) o;

        return x_axis == coordinate.x_axis && y_axis == coordinate.y_axis;
    }
}
