package ru.sbt.test.commands;

import ru.sbt.test.units.state.Unit;

abstract class BaseCommand implements Command {

    protected Unit unit;

    public BaseCommand(Unit unit) {
        this.unit = unit;
    }

    public abstract void execute();
}
