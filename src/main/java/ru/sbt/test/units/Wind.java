package ru.sbt.test.units;

import ru.sbt.test.units.state.Orientation;
import ru.sbt.test.units.state.Turning;

public class Wind implements Turning {
    private Orientation orientation;

    public Wind(Orientation orientation) {
        this.orientation = orientation;
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
