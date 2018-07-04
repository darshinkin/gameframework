package ru.sbt.test.units;

import ru.sbt.test.units.state.Coordinates;
import ru.sbt.test.units.state.Orientation;
import ru.sbt.test.units.state.Ammunition;
import ru.sbt.test.units.state.Shooting;
import ru.sbt.test.units.state.Turning;

public class SecurityTower implements Turning, Shooting {

    private Ammunition ammunition;
    private Orientation orientation;
    private Coordinates coordinaties;

    public SecurityTower(Ammunition ammunition, Orientation orientation, Coordinates coordinates) {
        this.ammunition = ammunition;
        this.orientation = orientation;
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

    public Coordinates getCoordinaties() {
        return coordinaties;
    }

    public void setCoordinaties(Coordinates coordinaties) {
        this.coordinaties = coordinaties;
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
