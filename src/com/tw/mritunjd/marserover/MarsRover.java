package com.tw.mritunjd.marserover;

import com.tw.mritunjd.marserover.cli.Interpreter;
import com.tw.mritunjd.marserover.cli.InputReader;
import com.tw.mritunjd.marserover.core.Movable;
import com.tw.mritunjd.marserover.factory.MarsRoverFactory;

import java.util.List;

public class MarsRover {
    public static void main(String[] args) {
        List<String> inputs = new InputReader().getInput();
        Interpreter interpreter = new Interpreter(new MarsRoverFactory());
        interpreter.performOperationOnInput(inputs);
    }
}
