package com.tw.mritunjd.marserover.factory;

import com.tw.mritunjd.marserover.core.Coordinate;
import com.tw.mritunjd.marserover.core.Plateau;
import com.tw.mritunjd.marserover.core.Rover;

public class MarsRoverFactory {

    public Rover createRover(Coordinate position, Character directionSymbol) {
        return new Rover(position, directionSymbol);
    }

    public Plateau createPlateau(Coordinate coordinate, MarsRoverFactory factory) {
        return new Plateau(coordinate, factory);
    }
}
