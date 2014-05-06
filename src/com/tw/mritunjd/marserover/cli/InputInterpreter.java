package com.tw.mritunjd.marserover.cli;

import com.tw.mritunjd.marserover.core.Coordinate;
import com.tw.mritunjd.marserover.core.Movable;
import com.tw.mritunjd.marserover.factory.MarsRoverFactory;

import java.util.ArrayList;
import java.util.List;

public class InputInterpreter {
    private List<String> inputs;
    private MarsRoverFactory factory;

    public InputInterpreter(List<String> inputs, MarsRoverFactory factory) {
        this.inputs = inputs;
        this.factory = factory;
    }

    public List<Movable> getMovablesByInput() {
        InputParser parser = new InputParser();
        List<Movable> movables = new ArrayList<>();
        int index = 1;
        while (index < inputs.size()) {
            String inputForInitRover = inputs.get(index++);
            Coordinate roverInitialCoordinates = parser.getCoordinatesFromInput(inputForInitRover);
            Character directionSymbol = parser.getDirectionSymbolFromInput(inputForInitRover);
            String instructionSeries = inputs.get(index++);
            Movable movable = factory.createRover(roverInitialCoordinates, directionSymbol);
            movable.setInstructions(instructionSeries);
            movables.add(movable);
        }
        return movables;
    }
}
