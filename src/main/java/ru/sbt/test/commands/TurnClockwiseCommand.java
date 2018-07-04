package ru.sbt.test.commands;

import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.state.State;
import ru.sbt.test.units.Unit;

import static ru.sbt.test.refactoring.Orientation.EAST;
import static ru.sbt.test.refactoring.Orientation.NORTH;
import static ru.sbt.test.refactoring.Orientation.SOUTH;
import static ru.sbt.test.refactoring.Orientation.WEST;

public class TurnClockwiseCommand extends BaseCommand {

    public TurnClockwiseCommand(Unit unit) {
        super(unit);
    }

    public void execute() {
        State state = getUnit().retrieveState();
        Orientation currentOrientation = state.getOrientation();
        switch (currentOrientation) {
            case EAST:
                currentOrientation = SOUTH;
                break;
            case SOUTH:
                currentOrientation = WEST;
                break;
            case WEST:
                currentOrientation = NORTH;
                break;
            case NORTH:
                currentOrientation = EAST;
        }
    }
}
