package com.tw.mritunjd.marserover;

import com.tw.mritunjd.marserover.cli.InputInterpreter;
import com.tw.mritunjd.marserover.cli.InstructionInterpreter;
import com.tw.mritunjd.marserover.cli.InputReader;
import com.tw.mritunjd.marserover.core.Movable;
import com.tw.mritunjd.marserover.factory.MarsRoverFactory;

import java.util.List;

public class MarsRover {
    public static void main(String[] args) {
        List<String> inputs = new InputReader().getInput();
        List<Movable> movables = new InputInterpreter(inputs, new MarsRoverFactory()).getMovablesByInput();
        InstructionInterpreter instructionInterpreter = new InstructionInterpreter(movables);
        List<Movable> movablesAfterExploration = instructionInterpreter.instructMovablesToExplore();
        for (Movable movable : movablesAfterExploration) {
            String location = movable.getLocation();
            System.out.println(location);
        }
    }
}
