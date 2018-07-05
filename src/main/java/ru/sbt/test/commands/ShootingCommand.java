package ru.sbt.test.commands;

import ru.sbt.test.units.state.Moving;
import ru.sbt.test.units.state.Shooting;
import ru.sbt.test.units.state.Turning;
import ru.sbt.test.units.state.Unit;

import java.util.List;

public class ShootingCommand extends BaseCommand {

    public ShootingCommand(Shooting shootingUnit) {
        super(shootingUnit);
    }

    public ShootingCommand(List<Unit> units) {
        super(units);
    }

    @Override
    public void execute() {
        executeUnit(this.unit);
    }

    private void executeUnit(Unit unit) {
        Shooting shooting = (Shooting) unit;
        int bullets = shooting.getAmmunition().getBullet();
        if (bullets > 0) {
            shooting.getAmmunition().setBullet(--bullets);
        }
        System.out.printf("Bullets have run out");
    }

    @Override
    public void executeBunch() {
        for (Unit unit : units) {
            if (unit instanceof Shooting) {
                executeUnit(unit);
            }
        }
    }
}
