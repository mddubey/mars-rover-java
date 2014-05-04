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
        verify(factory, times(1)).createRover(2, 2, 'N');
    }

    @Test
    public void shouldTurnRoverLeftWhenInstructionIsL() {
        StubFactory factory = new StubFactory();
        Plateau plateau = new Plateau(5, 5, factory);
        String instructions = "LLLLLL";
        plateau.initRover(1, 1, 'N');
        plateau.explorePlateau(instructions);
        verify(factory.rover,times(6)).turnLeft();
    }

    @Test
    public void shouldTurnRoverRightWhenInstructionIsR() {
        StubFactory factory = new StubFactory();
        Plateau plateau = new Plateau(5, 5, factory);
        String instructions = "RRRRRR";
        plateau.initRover(1, 1, 'N');
        plateau.explorePlateau(instructions);
        verify(factory.rover,times(6)).turnRight();
    }

    @Test
    public void shouldMoveRoverForwardWhenInstructionIsM() {
        StubFactory factory = new StubFactory();
        Plateau plateau = new Plateau(5, 5, factory);
        String instructions = "MMMMMM";
        plateau.initRover(1, 1, 'N');
        plateau.explorePlateau(instructions);
        verify(factory.rover,times(6)).moveForward();
    }

    @Test
    public void shouldCallRoverToMoveAccordingToInstruction() {
        StubFactory factory = new StubFactory();
        Plateau plateau = new Plateau(5, 5, factory);
        String instructions = "LLMMRRLMRMRL";
        plateau.initRover(1, 1, 'N');
        plateau.explorePlateau(instructions);
        verify(factory.rover,times(4)).turnLeft();
        verify(factory.rover,times(4)).moveForward();
        verify(factory.rover,times(4)).turnRight();
    }

    private class StubFactory extends MarsRoverFactory {
        public final Rover rover = mock(Rover.class);

        @Override
        public Rover createRover(int position_x_axis, int position_y_axis, Character directionSymbol) {
            return rover;
        }
    }
}
