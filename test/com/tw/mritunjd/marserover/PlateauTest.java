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
}
