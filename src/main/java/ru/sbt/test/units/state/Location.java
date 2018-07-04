package ru.sbt.test.units.state;

import ru.sbt.test.Coordinates;

public interface Location extends Unit {
    Coordinates getCoordinates();

    void setCoordinates(Coordinates coordinates);

    /*private Coordinates coordinates;

    public Location(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }*/
}
