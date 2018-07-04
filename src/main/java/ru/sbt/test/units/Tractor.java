package ru.sbt.test.units;

import ru.sbt.test.units.state.Coordinates;
import ru.sbt.test.units.state.Orientation;
import ru.sbt.test.units.state.Moving;
import ru.sbt.test.units.state.Turning;

public class Tractor implements Moving, Turning {

    private Orientation orientation;
    private Coordinates coordinates;

    public Tractor(Orientation orientation, Coordinates coordinates) {
        this.orientation = orientation;
        this.coordinates = coordinates;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
