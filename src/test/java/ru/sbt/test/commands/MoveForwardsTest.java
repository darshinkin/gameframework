package ru.sbt.test.commands;

import org.junit.Test;
import ru.sbt.test.Coordinates;
import ru.sbt.test.refactoring.TractorInDitchException;
import ru.sbt.test.state.Location;
import ru.sbt.test.state.State;
import ru.sbt.test.units.Tractor;
import ru.sbt.test.units.Unit;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.refactoring.Orientation.EAST;
import static ru.sbt.test.refactoring.Orientation.NORTH;
import static ru.sbt.test.refactoring.Orientation.SOUTH;
import static ru.sbt.test.refactoring.Orientation.WEST;

public class MoveForwardsTest {
    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToEastWithEx() {
        Coordinates field = new Coordinates(5, 5);
        Unit unit = new Tractor(new State(EAST, new Location(new Coordinates(5, 3))));
        Command command = new MoveForwardsCommand(unit, field);
        command.execute();
    }

    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToNorthWithEx() {
        Coordinates field = new Coordinates(5, 5);
        Unit unit = new Tractor(new State(NORTH, new Location(new Coordinates(3, 5))));
        Command command = new MoveForwardsCommand(unit, field);
        command.execute();
    }

    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToSouthWithEx() {
        Coordinates field = new Coordinates(5, 5);
        Unit unit = new Tractor(new State(SOUTH, new Location(new Coordinates(3, 0))));
        Command command = new MoveForwardsCommand(unit, field);
        command.execute();
    }

    @Test(expected = TractorInDitchException.class)
    public void testMoveForwardsOnTractorToWestWithEx() {
        Coordinates field = new Coordinates(5, 5);
        Unit unit = new Tractor(new State(WEST, new Location(new Coordinates(0, 3))));
        Command command = new MoveForwardsCommand(unit, field);
        command.execute();
    }

    @Test
    public void testMoveForwardsOnTractorToEast() {
        Coordinates field = new Coordinates(5, 5);
        Unit unit = new Tractor(new State(EAST, new Location(new Coordinates(3, 2))));
        Command command = new MoveForwardsCommand(unit, field);
        command.execute();
        assertEquals(4, unit.retrieveState().getLocation().getCoordinates().getX());
    }

    @Test
    public void testMoveForwardsOnTractorToNorth() {
        Coordinates field = new Coordinates(5, 5);
        Unit unit = new Tractor(new State(NORTH, new Location(new Coordinates(2, 3))));
        Command command = new MoveForwardsCommand(unit, field);
        command.execute();
        assertEquals(4, unit.retrieveState().getLocation().getCoordinates().getY());
    }

    @Test
    public void testMoveForwardsOnTractorToSouth() {
        Coordinates field = new Coordinates(5, 5);
        Unit unit = new Tractor(new State(SOUTH, new Location(new Coordinates(3, 2))));
        Command command = new MoveForwardsCommand(unit, field);
        command.execute();
        assertEquals(1, unit.retrieveState().getLocation().getCoordinates().getY());
        assertEquals(3, unit.retrieveState().getLocation().getCoordinates().getX());
    }

    @Test
    public void testMoveForwardsOnTractorToWest() {
        Coordinates field = new Coordinates(5, 5);
        Unit unit = new Tractor(new State(WEST, new Location(new Coordinates(1, 3))));
        Command command = new MoveForwardsCommand(unit, field);
        command.execute();
        assertEquals(0, unit.retrieveState().getLocation().getCoordinates().getX());
    }
}
