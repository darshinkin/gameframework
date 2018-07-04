package ru.sbt.test.commands;

import org.junit.Test;
import ru.sbt.test.units.Tank;
import ru.sbt.test.units.state.Coordinates;
import ru.sbt.test.units.state.Orientation;
import ru.sbt.test.units.SecurityTower;
import ru.sbt.test.units.state.Ammunition;

import static org.junit.Assert.assertEquals;

public class SootingTest {

    @Test
    public void testShootingFromSecurityTower() {
        SecurityTower securityTower = new SecurityTower
                (new Ammunition(100), Orientation.NORTH, new Coordinates(2,3));
        Command command = new ShootingCommand(securityTower);
        command.execute();
        assertEquals(99, securityTower.getAmmunition().getBullet());
    }

    @Test
    public void testShootingFromSecurityTowerWithZeroBullets() {
        SecurityTower securityTower = new SecurityTower
                (new Ammunition(0), Orientation.NORTH, new Coordinates(2,3));
        Command command = new ShootingCommand(securityTower);
        command.execute();
        assertEquals(0, securityTower.getAmmunition().getBullet());
    }

    @Test
    public void testShootingFromTank() {
        Tank tank = new Tank
                (new Ammunition(150), Orientation.NORTH, new Coordinates(2,5));
        Command command = new ShootingCommand(tank);
        command.execute();
        assertEquals(149, tank.getAmmunition().getBullet());
    }
}
