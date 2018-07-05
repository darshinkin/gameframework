package ru.sbt.test.commands;

import ru.sbt.test.units.state.Unit;

import java.util.List;

abstract class BaseCommand implements Command {

    protected Unit unit;
    protected List<Unit> units;

    public BaseCommand(Unit unit) {
        this.unit = unit;
    }

    public BaseCommand(List<Unit> units) {
        this.units = units;
    }

    public abstract void execute();

    public abstract void executeBunch();
}
