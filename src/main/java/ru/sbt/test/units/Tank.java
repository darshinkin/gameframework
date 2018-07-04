package ru.sbt.test.units;

import ru.sbt.test.units.state.*;

public class Tank implements Moving, Turning, Shooting {
    private Ammunition ammunition;
    private Orientation orientation;
    private Coordinates coordinaties;

    public Tank(Ammunition ammunition, Orientation orientation, Coordinates coordinates) {
        this.ammunition = ammunition;
        this.orientation = orientation;
        this.coordinaties = coordinates;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinaties;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinaties = coordinates;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public Ammunition getAmmunition() {
        return ammunition;
    }

    @Override
    public void setAmmunation(Ammunition ammunation) {
        this.ammunition = ammunation;
    }
}
