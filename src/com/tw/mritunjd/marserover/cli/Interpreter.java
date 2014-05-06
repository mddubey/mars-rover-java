package com.tw.mritunjd.marserover.cli;

import com.tw.mritunjd.marserover.core.Coordinate;
import com.tw.mritunjd.marserover.core.Movable;
import com.tw.mritunjd.marserover.factory.MarsRoverFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interpreter {
    private MarsRoverFactory factory;
    private Map<Character, MoveAction> actionMap = new HashMap();

    public Interpreter(MarsRoverFactory factory) {
        this.factory = factory;
        setMoveActions(actionMap);
    }

    private void setMoveActions(Map<Character, MoveAction> actionMap) {
        MoveAction turnLeftAction = new MoveAction() {
            @Override
            public void makeItMoved(Movable movable) {
                movable.turnLeft();
            }
        };
        MoveAction turnRightAction = new MoveAction() {
            @Override
            public void makeItMoved(Movable movable) {
                movable.turnRight();
            }
        };
        MoveAction moveForwardAction = new MoveAction() {
            @Override
            public void makeItMoved(Movable movable) {
                movable.moveForward();
            }
        };

        actionMap.put('R', turnRightAction);
        actionMap.put('L', turnLeftAction);
        actionMap.put('M', moveForwardAction);
    }

    public void performOperationOnInput(List<String> inputs) {
        InputParser parser = new InputParser();
        Coordinate upperRightCoordinates = parser.getCoordinatesFromInput(inputs.get(0));
        System.out.println("Location after exploration:--");
        int index = 1;
        while (index < inputs.size()) {
            String inputForInitRover = inputs.get(index++);
            Coordinate roverInitialCoordinates = parser.getCoordinatesFromInput(inputForInitRover);
            Character directionSymbol = parser.getDirectionSymbolFromInput(inputForInitRover);
            String instructionSeries = inputs.get(index++);
            Movable movable = factory.createRover(roverInitialCoordinates, directionSymbol);
            for (int i = 0; i < instructionSeries.length(); i++) {
                Character instruction = instructionSeries.charAt(i);
                actionMap.get(instruction).makeItMoved(movable);
            }
            String result = movable.getLocation();
            System.out.println(result);
        }
    }
}
