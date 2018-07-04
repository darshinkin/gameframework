package ru.sbt.test.commands;

import ru.sbt.test.Coordinates;
import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.TractorInDitchException;
import ru.sbt.test.units.state.Location;
import ru.sbt.test.units.state.Turning;
import ru.sbt.test.units.state.Unit;

public class MoveForwardsCommand extends BaseCommand {

    //todo should be inicialized during of the luanching programm
    private static Coordinates field = new Coordinates(5, 5);

    public MoveForwardsCommand(Unit unit) {
        super(unit);
    }

    @Override
    public void execute() {
        Orientation currentOrientation = ((Turning) unit).getOrientation();
        Location unit = (Location) this.unit;
        Coordinates coordinates = unit.getCoordinates();
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
        unit.setCoordinates(coordinates);
    }
}
