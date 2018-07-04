package ru.sbt.test.commands;

import org.junit.Test;
import ru.sbt.test.Coordinates;
import ru.sbt.test.refactoring.TractorInDitchException;
import ru.sbt.test.units.state.Location;
import ru.sbt.test.units.Tractor;
import ru.sbt.test.units.state.Unit;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.refactoring.Orientation.EAST;
import static ru.sbt.test.refactoring.Orientation.NORTH;
import static ru.sbt.test.refactoring.Orientation.SOUTH;
import static ru.sbt.test.refactoring.Orientation.WEST;

public class MoveForwardsTest {
    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToEastWithEx() {
        Unit unit = new Tractor(EAST, new Coordinates(5, 3));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
    }

    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToNorthWithEx() {
        Unit unit = new Tractor(NORTH, new Coordinates(3, 5));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
    }

    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToSouthWithEx() {
        Unit unit = new Tractor(SOUTH, new Coordinates(3, 0));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
    }

    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToWestWithEx() {
        Unit unit = new Tractor(WEST, new Coordinates(0, 3));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
    }

    @Test
    public void testMoveForwardsOnTractorToEast() {
        Location unit = new Tractor(EAST, new Coordinates(3, 2));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
        assertEquals(4, unit.getCoordinates().getX());
    }

    @Test
    public void testMoveForwardsOnTractorToNorth() {
        Location unit = new Tractor(NORTH, new Coordinates(2, 3));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
        assertEquals(4, unit.getCoordinates().getY());
    }

    @Test
    public void testMoveForwardsOnTractorToSouth() {
        Location unit = new Tractor(SOUTH, new Coordinates(3, 2));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
        assertEquals(1, unit.getCoordinates().getY());
        assertEquals(3, unit.getCoordinates().getX());
    }

    @Test
    public void testMoveForwardsOnTractorToWest() {
        Location unit = new Tractor(WEST, new Coordinates(1, 3));
        Command command = new MoveForwardsCommand(unit);
        command.execute();
        assertEquals(0, unit.getCoordinates().getX());
    }
}
