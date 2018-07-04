package ru.sbt.test.units.state;

public interface Moving extends Unit {
    Coordinates getCoordinates();

    void setCoordinates(Coordinates coordinates);
}
