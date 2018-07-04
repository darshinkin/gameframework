package ru.sbt.test.commands;

import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.units.state.Turning;

import static ru.sbt.test.refactoring.Orientation.EAST;
import static ru.sbt.test.refactoring.Orientation.NORTH;
import static ru.sbt.test.refactoring.Orientation.SOUTH;
import static ru.sbt.test.refactoring.Orientation.WEST;

public class TurnClockwiseCommand implements Command {

    private Turning unit;

    public TurnClockwiseCommand(Turning unit) {
        this.unit = unit;
    }

    public void execute() {
        Orientation currentOrientation = unit.getOrientation();
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
        unit.setOrientation(currentOrientation);
    }
}
