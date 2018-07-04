package ru.sbt.test.commands;

import ru.sbt.test.units.state.Shooting;

public class ShootingCommand extends BaseCommand {

    public ShootingCommand(Shooting shootingUnit) {
        super(shootingUnit);
    }

    @Override
    public void execute() {
        Shooting shooting = (Shooting) unit;
        int bullets = shooting.getAmmunition().getBullet();
        if (bullets > 0) {
            shooting.getAmmunition().setBullet(--bullets);
        }
        System.out.printf("Bullets have run out");
    }
}
