package ru.sbt.test.units;

import ru.sbt.test.units.state.Coordinates;
import ru.sbt.test.units.state.Unit;

public class Stone implements Unit {
    private Coordinates coordinates;

    public Stone(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
