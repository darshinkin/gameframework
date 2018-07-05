package ru.sbt.test.commands;

import ru.sbt.test.units.state.Moving;
import ru.sbt.test.units.state.Orientation;
import ru.sbt.test.units.state.Turning;
import ru.sbt.test.units.state.Unit;

import java.util.List;

import static ru.sbt.test.units.state.Orientation.EAST;
import static ru.sbt.test.units.state.Orientation.NORTH;
import static ru.sbt.test.units.state.Orientation.SOUTH;
import static ru.sbt.test.units.state.Orientation.WEST;

public class TurnClockwiseCommand extends BaseCommand {

    public TurnClockwiseCommand(Turning unit) {
        super(unit);
    }

    public TurnClockwiseCommand(List<Unit> units) {
        super(units);
    }

    public void execute() {
        executeUnit(this.unit);
    }

    private void executeUnit(Unit unit) {
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

    @Override
    public void executeBunch() {
        for (Unit unit : units) {
            if (unit instanceof Turning) {
                executeUnit(unit);
            }
        }
    }
}
