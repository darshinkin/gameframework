package ru.sbt.test.commands;

import ru.sbt.test.units.state.*;
import ru.sbt.test.exeptions.TractorInDitchException;

import java.util.List;

public class MoveForwardsCommand extends BaseCommand {

    //todo should be inicialized during of the luanching programm
    private static Coordinates field = new Coordinates(5, 5);

    public MoveForwardsCommand(Moving unit) {
        super(unit);
    }

    public MoveForwardsCommand(List<Unit> units) {
        super(units);
    }

    @Override
    public void execute() {
        executUnit(this.unit);
    }

    private void executUnit(Unit unit) {
        Orientation currentOrientation = ((Turning) unit).getOrientation();
        Coordinates coordinates = ((Moving) unit).getCoordinates();
        switch (currentOrientation) {
            case EAST:
                int newPosition = coordinates.getX() + 1;
                if (newPosition > field.getX()) {
                    throw new TractorInDitchException();
                }
                coordinates = new Coordinates(newPosition, coordinates.getY());
                break;
            case SOUTH:
                newPosition = coordinates.getY() - 1;
                if (newPosition < 0) {
                    throw new TractorInDitchException();
                }
                coordinates = new Coordinates(coordinates.getX(), newPosition);
                break;
            case WEST:
                newPosition = coordinates.getX() - 1;
                if (newPosition < 0) {
                    throw new TractorInDitchException();
                }
                coordinates = new Coordinates(newPosition, coordinates.getY());
                break;
            case NORTH:
                newPosition = coordinates.getY() + 1;
                if (newPosition > field.getY()) {
                    throw new TractorInDitchException();
                }
                coordinates = new Coordinates(coordinates.getX(), newPosition);
        }
        ((Moving) unit).setCoordinates(coordinates);
    }

    @Override
    public void executeBunch() {
        for (Unit unit : units) {
            if (unit instanceof Moving && unit instanceof Turning) {
                executUnit(unit);
            }
        }
    }
}
