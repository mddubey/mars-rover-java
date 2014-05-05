package com.tw.mritunjd.marserover;

import com.tw.mritunjd.marserover.factory.MarsRoverFactory;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PlateauTest {

    @Test
    public void shouldTellTwoPlateausAreEqual() {
        Plateau expected = new Plateau(5, 5, new MarsRoverFactory());
        Plateau actual = new Plateau(5, 5, new MarsRoverFactory());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTellTwoPlateausAreNotEqual() {
        Plateau expected = new Plateau(5, 5, new MarsRoverFactory());
        Plateau actual = new Plateau(5, 4, new MarsRoverFactory());
        assertNotSame(expected, actual);
    }

    @Test
    public void shouldCreateARover() {
        MarsRoverFactory factory = mock(MarsRoverFactory.class);
        Plateau plateau = new Plateau(5, 5, factory);
        plateau.initRover(2, 2, 'N');
        verify(factory, times(1)).createRover(new Coordinate(2, 2), 'N');
    }

    @Test
    public void shouldInstructRoverToTurnLeftWhenInstructionIsL() {
        StubFactory factory = new StubFactory();
        Plateau plateau = new Plateau(5, 5, factory);
        String instructions = "LLLLLL";
        plateau.initRover(1, 1, 'N');
        plateau.explorePlateau(instructions);
        verify(factory.rover, times(6)).turnLeft();
    }

    @Test
    public void shouldInstructRoverToTurnRightWhenInstructionIsR() {
        StubFactory factory = new StubFactory();
        Plateau plateau = new Plateau(5, 5, factory);
        String instructions = "RRRRRR";
        plateau.initRover(1, 1, 'N');
        plateau.explorePlateau(instructions);
        verify(factory.rover, times(6)).turnRight();
    }

    @Test
    public void shouldInstructRoverToMoveForwardWhenInstructionIsM() {
        StubFactory factory = new StubFactory();
        Plateau plateau = new Plateau(5, 5, factory);
        String instructions = "MMMMMM";
        plateau.initRover(1, 1, 'N');
        plateau.explorePlateau(instructions);
        verify(factory.rover, times(6)).moveForward();
    }

    @Test
    public void shouldInstructRoverToMoveAccordingToInstruction() {
        StubFactory factory = new StubFactory();
        Plateau plateau = new Plateau(5, 5, factory);
        String instructions = "LLMMRRLMRMRL";
        plateau.initRover(1, 1, 'N');
        plateau.explorePlateau(instructions);
        verify(factory.rover, times(4)).turnLeft();
        verify(factory.rover, times(4)).moveForward();
        verify(factory.rover, times(4)).turnRight();
    }

    @Test
    public void shouldAskForTheCurrentLocationOfRover() {
        StubFactory factory = new StubFactory();
        Plateau plateau = new Plateau(5, 5, factory);
        plateau.initRover(1, 1, 'N');
        plateau.getRoverLocation();
        verify(factory.rover, times(1)).getLocation();
    }

    private class StubFactory extends MarsRoverFactory {
        public final Rover rover = mock(Rover.class);

        @Override
        public Rover createRover(Coordinate position, Character directionSymbol) {
            return rover;
        }
    }
}
