package ru.sbt.test.units;

import ru.sbt.test.state.State;

public class BaseUnit implements Unit{
    private State state;

    public BaseUnit(State state) {
        this.state = state;
    }

    public State retrieveState() {
        return state;
    }
}
