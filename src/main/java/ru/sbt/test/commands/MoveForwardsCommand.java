package ru.sbt.test.commands;

import ru.sbt.test.units.state.Coordinates;
import ru.sbt.test.units.state.Orientation;
import ru.sbt.test.exeptions.TractorInDitchException;
import ru.sbt.test.units.state.Moving;
import ru.sbt.test.units.state.Turning;

public class MoveForwardsCommand extends BaseCommand {

    //todo should be inicialized during of the luanching programm
    private static Coordinates field = new Coordinates(5, 5);

    public MoveForwardsCommand(Moving unit) {
        super(unit);
    }

    @Override
    public void execute() {
        Orientation currentOrientation = ((Turning) unit).getOrientation();
        Moving unit = (Moving) this.unit;
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
