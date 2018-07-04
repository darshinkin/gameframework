package ru.sbt.test.commands;

import ru.sbt.test.units.state.Orientation;
import ru.sbt.test.units.state.Turning;

import static ru.sbt.test.units.state.Orientation.EAST;
import static ru.sbt.test.units.state.Orientation.NORTH;
import static ru.sbt.test.units.state.Orientation.SOUTH;
import static ru.sbt.test.units.state.Orientation.WEST;

public class TurnClockwiseCommand extends BaseCommand {

    public TurnClockwiseCommand(Turning unit) {
        super(unit);
    }

    public void execute() {
        Orientation currentOrientation = ((Turning) unit).getOrientation();
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
        ((Turning) unit).setOrientation(currentOrientation);
    }
}
