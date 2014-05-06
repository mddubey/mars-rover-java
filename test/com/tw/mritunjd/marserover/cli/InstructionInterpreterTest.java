package com.tw.mritunjd.marserover.cli;

import com.tw.mritunjd.marserover.core.Coordinate;
import com.tw.mritunjd.marserover.core.Movable;
import com.tw.mritunjd.marserover.core.Rover;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class InstructionInterpreterTest {
    @Test
    public void shouldInstructMovableToTurnLeftWhenInstructionIsL() {
        Movable movable = mock(Movable.class);
        when(movable.getInstructions()).thenReturn("LL");
        InstructionInterpreter interpreter = new InstructionInterpreter(Arrays.asList(movable));
        interpreter.instructMovablesToExplore();
        verify(movable, times(2)).turnLeft();
    }

    @Test
    public void shouldInstructMovableToTurnRightWhenInstructionIsR() {
        Movable movable = mock(Movable.class);
        when(movable.getInstructions()).thenReturn("RR");
        InstructionInterpreter interpreter = new InstructionInterpreter(Arrays.asList(movable));
        interpreter.instructMovablesToExplore();
        verify(movable, times(2)).turnRight();
    }

    @Test
    public void shouldInstructMovableToGoForwardWhenInstructionIsM() {
        Movable movable = mock(Movable.class);
        when(movable.getInstructions()).thenReturn("MM");
        InstructionInterpreter interpreter = new InstructionInterpreter(Arrays.asList(movable));
        interpreter.instructMovablesToExplore();
        verify(movable, times(2)).moveForward();
    }

    @Test
    public void shouldInstructMovableAccordingToInstructions() {
        Movable movable = mock(Movable.class);
        when(movable.getInstructions()).thenReturn("MMRRLLM");
        InstructionInterpreter interpreter = new InstructionInterpreter(Arrays.asList(movable));
        interpreter.instructMovablesToExplore();
        verify(movable, times(2)).turnLeft();
        verify(movable, times(2)).turnRight();
        verify(movable, times(3)).moveForward();
    }

    @Test
    public void shouldInstructAllMovablesAccordingToTheirInstructions() {
        Movable movable1 = mock(Movable.class);
        when(movable1.getInstructions()).thenReturn("RR");
        Movable movable2 = mock(Movable.class);
        when(movable2.getInstructions()).thenReturn("LL");
        InstructionInterpreter interpreter = new InstructionInterpreter(Arrays.asList(movable1, movable2));
        interpreter.instructMovablesToExplore();
        verify(movable1, times(2)).turnRight();
        verify(movable2, times(2)).turnLeft();
    }

    @Test
    public void shouldGiveAllTheMovablesAfterTheirExplorationState() {
        Movable actual = new Rover(new Coordinate(2, 3), 'N');
        Movable expected = new Rover(new Coordinate(3, 4), 'E');
        actual.setInstructions("MRM");
        expected.setInstructions("MRM");
        InstructionInterpreter interpreter = new InstructionInterpreter(Arrays.asList(actual));
        List<Movable> movables = interpreter.instructMovablesToExplore();
        assertEquals(expected, movables.get(0));
    }
}
