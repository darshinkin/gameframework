package ru.sbt.test.commands;

import ru.sbt.test.units.Unit;

abstract class BaseCommand implements Command {

    private Unit unit;

    public BaseCommand(Unit unit) {
        this.unit = unit;
    }

    public abstract void execute();

    public Unit getUnit() {
        return unit;
    }
}
