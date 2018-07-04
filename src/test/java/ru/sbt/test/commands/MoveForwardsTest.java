package ru.sbt.test.commands;

import org.junit.Test;
import ru.sbt.test.units.state.Coordinates;
import ru.sbt.test.exeptions.TractorInDitchException;
import ru.sbt.test.units.state.Moving;
import ru.sbt.test.units.Tractor;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.units.state.Orientation.EAST;
import static ru.sbt.test.units.state.Orientation.NORTH;
import static ru.sbt.test.units.state.Orientation.SOUTH;
import static ru.sbt.test.units.state.Orientation.WEST;

public class MoveForwardsTest {
    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToEastWithEx() {
        Tractor unit = new Tractor(EAST, new Coordinates(5, 3));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
    }

    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToNorthWithEx() {
        Tractor unit = new Tractor(NORTH, new Coordinates(3, 5));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
    }

    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToSouthWithEx() {
        Tractor unit = new Tractor(SOUTH, new Coordinates(3, 0));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
    }

    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToWestWithEx() {
        Tractor unit = new Tractor(WEST, new Coordinates(0, 3));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
    }

    @Test
    public void testMoveForwardsOnTractorToEast() {
        Moving unit = new Tractor(EAST, new Coordinates(3, 2));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
        assertEquals(4, unit.getCoordinates().getX());
    }

    @Test
    public void testMoveForwardsOnTractorToNorth() {
        Moving unit = new Tractor(NORTH, new Coordinates(2, 3));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
        assertEquals(4, unit.getCoordinates().getY());
    }

    @Test
    public void testMoveForwardsOnTractorToSouth() {
        Moving unit = new Tractor(SOUTH, new Coordinates(3, 2));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
        assertEquals(1, unit.getCoordinates().getY());
        assertEquals(3, unit.getCoordinates().getX());
    }

    @Test
    public void testMoveForwardsOnTractorToWest() {
        Moving unit = new Tractor(WEST, new Coordinates(1, 3));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
        assertEquals(0, unit.getCoordinates().getX());
    }

    @Test
    public void testMoveForwardsOnTankToSouth() {
        Moving unit = new Tractor(SOUTH, new Coordinates(1, 3));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
        assertEquals(2, unit.getCoordinates().getY());
        assertEquals(1, unit.getCoordinates().getX());
    }
}
