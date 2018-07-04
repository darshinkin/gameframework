package ru.sbt.test;

import org.junit.Test;
import ru.sbt.test.commands.Command;
import ru.sbt.test.commands.TurnClockwiseCommand;
import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.state.Location;
import ru.sbt.test.state.State;
import ru.sbt.test.units.Tractor;
import ru.sbt.test.units.Unit;

public class NewTractorTest {

    @Test
    public void testTurnClockwiseOnTractor() {
        Unit unit = new Tractor(new State(Orientation.EAST, new Location(new Coordinates(2, 3))));
        Command command = new TurnClockwiseCommand(unit);
        command.execute();
    }
}
