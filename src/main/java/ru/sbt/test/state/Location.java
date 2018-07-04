package ru.sbt.test.state;

import ru.sbt.test.Coordinates;

public class Location {
    private Coordinates coordinates;

    public Location(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
