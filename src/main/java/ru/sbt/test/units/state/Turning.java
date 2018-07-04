package ru.sbt.test.units.state;

public interface Turning extends Unit {
    Orientation getOrientation();

    void setOrientation(Orientation currentOrientation);
}
