package com.tw.mritunjd.marserover.factory;

import com.tw.mritunjd.marserover.Rover;

public class MarsRoverFactory {

    public Rover createRover(int position_x_axis, int position_y_axis, Character directionSymbol) {
        return new Rover(position_x_axis, position_y_axis, directionSymbol);
    }
}
