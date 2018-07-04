package ru.sbt.test.commands;

import org.junit.Test;
import ru.sbt.test.units.Tank;
import ru.sbt.test.units.state.Coordinates;
import ru.sbt.test.units.state.Orientation;
import ru.sbt.test.units.SecurityTower;
import ru.sbt.test.units.Wind;
import ru.sbt.test.units.state.Ammunition;
import ru.sbt.test.units.state.Turning;
import ru.sbt.test.units.Tractor;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.units.state.Orientation.EAST;
import static ru.sbt.test.units.state.Orientation.NORTH;
import static ru.sbt.test.units.state.Orientation.SOUTH;

public class TurnClockwiseTest {

    @Test
    public void testTurnClockwiseOnTractor() {
        Turning unit = new Tractor(EAST, new Coordinates(2, 3));
        Command command = new TurnClockwiseCommand(unit);
        command.execute();

        assertEquals(SOUTH, unit.getOrientation());
    }

    @Test
    public void testWindTurn() {
        Wind wind = new Wind(Orientation.EAST);
        Command command = new TurnClockwiseCommand(wind);
        command.execute();
        assertEquals(Orientation.SOUTH, wind.getOrientation());
    }

    @Test
    public void testSecurityTowerTurn() {
        SecurityTower securityTower = new SecurityTower
                (new Ammunition(100), Orientation.NORTH, new Coordinates(2,3));
        Command command = new TurnClockwiseCommand(securityTower);
        command.execute();
        assertEquals(EAST, securityTower.getOrientation());
    }

    @Test
    public void testTankTurn() {
        Tank tank = new Tank
                (new Ammunition(100), Orientation.WEST, new Coordinates(2,3));
        Command command = new TurnClockwiseCommand(tank);
        command.execute();
        assertEquals(NORTH, tank.getOrientation());
    }
}
