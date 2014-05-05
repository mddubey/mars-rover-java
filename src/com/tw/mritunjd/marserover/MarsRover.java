package com.tw.mritunjd.marserover;

import com.tw.mritunjd.marserover.factory.MarsRoverFactory;

import java.util.List;

public class MarsRover {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter(new MarsRoverFactory());
        List<String> inputs = interpreter.getInput();
        interpreter.performOperationOnInput(inputs);
    }
}
