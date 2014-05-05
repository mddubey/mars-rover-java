package com.tw.mritunjd.marserover;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

public class RoverTest {
    @Test
    public void shouldTellTwoRoversAreEqual() {
        Rover expected = new Rover(new Coordinate(2, 2), 'N');
        Rover actual = new Rover(new Coordinate(2, 2), 'N');
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTellTwoRoversAreNotEqualWhenDirectionSymbolsAreNotEqual() {
        Rover expected = new Rover(new Coordinate(2, 2), 'N');
        Rover actual = new Rover(new Coordinate(2, 2), 'S');
        assertNotSame(expected, actual);
    }

    @Test
    public void shouldChangeDirectionToNorthFromEastOnTurningLeft() {
        Rover expected = new Rover(new Coordinate(2, 2), 'N');
        Rover actual = new Rover(new Coordinate(2, 2), 'E');
        actual.turnLeft();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeDirectionToNorthFromWestOnTurningRight() {
        Rover expected = new Rover(new Coordinate(2, 2), 'N');
        Rover actual = new Rover(new Coordinate(2, 2), 'W');
        actual.turnRight();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeDirectionToEastFromSouthOnTurningLeft() {
        Rover expected = new Rover(new Coordinate(2, 2), 'E');
        Rover actual = new Rover(new Coordinate(2, 2), 'S');
        actual.turnLeft();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeDirectionToEastFromNorthOnTurningRight() {
        Rover expected = new Rover(new Coordinate(2, 2), 'E');
        Rover actual = new Rover(new Coordinate(2, 2), 'N');
        actual.turnRight();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeDirectionToWestFromNorthOnTurningLeft() {
        Rover expected = new Rover(new Coordinate(2, 2), 'W');
        Rover actual = new Rover(new Coordinate(2, 2), 'N');
        actual.turnLeft();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeDirectionToWestFromSouthOnTurningRight() {
        Rover expected = new Rover(new Coordinate(2, 2), 'W');
        Rover actual = new Rover(new Coordinate(2, 2), 'S');
        actual.turnRight();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeDirectionToSouthFromWestOnTurningLeft() {
        Rover expected = new Rover(new Coordinate(2, 2), 'S');
        Rover actual = new Rover(new Coordinate(2, 2), 'W');
        actual.turnLeft();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeDirectionToSouthFromEastOnTurningRight() {
        Rover expected = new Rover(new Coordinate(2, 2), 'S');
        Rover actual = new Rover(new Coordinate(2, 2), 'E');
        actual.turnRight();
        assertEquals(expected, actual);
    }

    @Test
    public void xAxisShouldIncreaseByOneOnMoveWhenDirectionIsNorth() {
        Rover expected = new Rover(new Coordinate(2, 3), 'N');
        Rover actual = new Rover(new Coordinate(2, 2), 'N');
        actual.moveForward();
        assertEquals(expected, actual);
    }

    @Test
    public void xAxisShouldDecreasedByOneOnMoveWhenDirectionIsSouth() {
        Rover expected = new Rover(new Coordinate(2, 1), 'S');
        Rover actual = new Rover(new Coordinate(2, 2), 'S');
        actual.moveForward();
        assertEquals(expected, actual);
    }

    @Test
    public void yAxisShouldIncreaseByOneOnMoveWhenDirectionIsEast() {
        Rover expected = new Rover(new Coordinate(3, 2), 'E');
        Rover actual = new Rover(new Coordinate(2, 2), 'E');
        actual.moveForward();
        assertEquals(expected, actual);
    }

    @Test
    public void yAxisShouldDecreasedByOneOnMoveWhenDirectionIsWest() {
        Rover expected = new Rover(new Coordinate(1, 4), 'W');
        Rover actual = new Rover(new Coordinate(2, 4), 'W');
        actual.moveForward();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTellCurrentLocation() {
        String expectedLocation = "2 5 N";
        Rover rover = new Rover(new Coordinate(2, 5), 'N');
        String actualLocation = rover.getLocation();
        assertEquals(expectedLocation, actualLocation);
    }

    @Test
    public void shouldTellCurrentLocationAfterMove() {
        String expectedLocation = "2 5 N";
        Rover rover = new Rover(new Coordinate(3, 5), 'S');
        rover.turnRight();
        rover.moveForward();
        rover.turnRight();
        String actualLocation = rover.getLocation();
        assertEquals(expectedLocation, actualLocation);
    }
}
