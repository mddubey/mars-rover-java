package com.tw.mritunjd.marserover.cli;

import com.tw.mritunjd.marserover.core.Movable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstructionInterpreter {
    private List<Movable> movables;
    private Map<Character, MoveAction> actionMap = new HashMap();

    public InstructionInterpreter(List<Movable> movables) {
        this.movables = movables;
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

    public List<Movable> instructMovablesToExplore() {
        for (Movable movable : movables) {
            String instructionSeries = movable.getInstructions();
            for (int i = 0; i < instructionSeries.length(); i++) {
                Character instruction = instructionSeries.charAt(i);
                actionMap.get(instruction).makeItMoved(movable);
            }
        }
        return movables;
    }
}
