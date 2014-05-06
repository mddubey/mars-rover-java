package com.tw.mritunjd.marserover.cli;

import com.tw.mritunjd.marserover.core.Coordinate;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class InputParserTest {
    @Test
    public void shouldGiveUpperRightCoordinatesOfPlateau(){
        String input = "5 5";
        Coordinate expected = new Coordinate(5, 5);
        InputParser parser = new InputParser();
        Coordinate coordinate = parser.getCoordinatesFromInput(input);
        assertEquals(expected, coordinate);
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowNumberFormatExceptionWithMessage() {
        String input = "5 s";
        Coordinate expected = new Coordinate(5, 5);
        InputParser parser = new InputParser();
        Coordinate coordinate = parser.getCoordinatesFromInput(input);
    }

}
