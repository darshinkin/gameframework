package ru.sbt.test.state;

import ru.sbt.test.refactoring.Orientation;

public class State {
    private Orientation orientation;
    private Location location;

    public State(Orientation orientation, Location location) {
        this.orientation = orientation;
        this.location = location;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
