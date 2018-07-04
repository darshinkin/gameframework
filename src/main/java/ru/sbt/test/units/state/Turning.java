package ru.sbt.test.units.state;

import ru.sbt.test.refactoring.Orientation;

public interface Turning extends Unit {
    Orientation getOrientation();

    void setOrientation(Orientation currentOrientation);
}
