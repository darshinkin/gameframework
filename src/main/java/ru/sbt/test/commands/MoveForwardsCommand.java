package ru.sbt.test.commands;

import ru.sbt.test.Coordinates;
import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.TractorInDitchException;
import ru.sbt.test.state.State;
import ru.sbt.test.units.Unit;

public class MoveForwardsCommand extends BaseCommand {
    private Coordinates field;

    public MoveForwardsCommand(Unit unit, Coordinates coordinates) {
        super(unit);
        this.field = coordinates;
    }

    @Override
    public void execute() {
        State state = getUnit().retrieveState();
        Orientation currentOrientation = state.getOrientation();
        Coordinates coordinates = state.getLocation().getCoordinates();
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
        state.getLocation().setCoordinates(coordinates);
    }
}
