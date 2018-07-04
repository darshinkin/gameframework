package ru.sbt.test.commands;

import org.junit.Test;
import ru.sbt.test.Coordinates;
import ru.sbt.test.units.state.Turning;
import ru.sbt.test.units.Tractor;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.refactoring.Orientation.EAST;
import static ru.sbt.test.refactoring.Orientation.SOUTH;

public class TurnClockwiseTest {

    @Test
    public void testTurnClockwiseOnTractor() {
        Turning unit = new Tractor(EAST, new Coordinates(2, 3));
        Command command = new TurnClockwiseCommand(unit);
        command.execute();

        assertEquals(SOUTH, unit.getOrientation());
    }
}
