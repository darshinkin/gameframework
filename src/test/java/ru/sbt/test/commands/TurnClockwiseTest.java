package ru.sbt.test.commands;

import org.junit.Test;
import ru.sbt.test.Coordinates;
import ru.sbt.test.commands.Command;
import ru.sbt.test.commands.MoveForwardsCommand;
import ru.sbt.test.commands.TurnClockwiseCommand;
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

public class TurnClockwiseTest {

    @Test
    public void testTurnClockwiseOnTractor() {
        Unit unit = new Tractor(new State(EAST, new Location(new Coordinates(2, 3))));
        Command command = new TurnClockwiseCommand(unit);
        command.execute();

        assertEquals(SOUTH, unit.retrieveState().getOrientation());
    }
}
