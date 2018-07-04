package ru.sbt.test.units;

import ru.sbt.test.units.state.Coordinates;

public class Stone {
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
