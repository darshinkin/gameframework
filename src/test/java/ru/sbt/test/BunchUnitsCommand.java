package ru.sbt.test;

import org.junit.Test;
import ru.sbt.test.commands.Command;
import ru.sbt.test.commands.MoveForwardsCommand;
import ru.sbt.test.commands.ShootingCommand;
import ru.sbt.test.commands.TurnClockwiseCommand;
import ru.sbt.test.units.*;
import ru.sbt.test.units.state.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.units.state.Orientation.EAST;
import static ru.sbt.test.units.state.Orientation.SOUTH;

public class BunchUnitsCommand {

    @Test
    public void testBunchUnitsMoving() {
        List<Unit> units = new ArrayList<>();
        Unit tank = new Tank
                (new Ammunition(150), Orientation.NORTH, new Coordinates(2,4));
        Unit tractor = new Tractor(EAST, new Coordinates(2, 3));
        Unit wind = new Wind(Orientation.EAST);
        Unit securityTower = new SecurityTower
                (new Ammunition(100), Orientation.NORTH, new Coordinates(2,3));
        Unit stone = new Stone(new Coordinates(3, 2));
        units.add(tank);
        units.add(tractor);
        units.add(wind);
        units.add(securityTower);
        units.add(stone);

        Command command = new MoveForwardsCommand(units);
        ((MoveForwardsCommand) command).executeBunch();

        assertEquals(5, ((Tank) tank).getCoordinates().getY());
        assertEquals(3, ((Tractor) tractor).getCoordinates().getX());
        assertEquals(2, ((SecurityTower) securityTower).getCoordinaties().getX());
        assertEquals(3, ((SecurityTower) securityTower).getCoordinaties().getY());
        assertEquals(3, ((Stone) stone).getCoordinates().getX());
        assertEquals(2, ((Stone) stone).getCoordinates().getY());
    }

    @Test
    public void testBunchUnitsTurn() {
        List<Unit> units = new ArrayList<>();
        Unit tank = new Tank
                (new Ammunition(150), Orientation.NORTH, new Coordinates(2,4));
        Unit tractor = new Tractor(EAST, new Coordinates(2, 3));
        Unit wind = new Wind(Orientation.EAST);
        Unit securityTower = new SecurityTower
                (new Ammunition(100), Orientation.NORTH, new Coordinates(2,3));
        Unit stone = new Stone(new Coordinates(3, 2));
        units.add(tank);
        units.add(tractor);
        units.add(wind);
        units.add(securityTower);
        units.add(stone);

        Command command = new TurnClockwiseCommand(units);
        ((TurnClockwiseCommand) command).executeBunch();

        assertEquals(EAST, ((Tank) tank).getOrientation());
        assertEquals(SOUTH, ((Tractor) tractor).getOrientation());
        assertEquals(EAST, ((SecurityTower) securityTower).getOrientation());
        assertEquals(SOUTH, ((Wind) wind).getOrientation());
    }

    @Test
    public void testBunchUnitsShooting() {
        List<Unit> units = new ArrayList<>();
        Unit tank = new Tank
                (new Ammunition(150), Orientation.NORTH, new Coordinates(2,4));
        Unit tractor = new Tractor(EAST, new Coordinates(2, 3));
        Unit wind = new Wind(Orientation.EAST);
        Unit securityTower = new SecurityTower
                (new Ammunition(100), Orientation.NORTH, new Coordinates(2,3));
        Unit stone = new Stone(new Coordinates(3, 2));
        units.add(tank);
        units.add(tractor);
        units.add(wind);
        units.add(securityTower);
        units.add(stone);

        Command command = new ShootingCommand(units);
        ((ShootingCommand) command).executeBunch();

        assertEquals(149, ((Tank) tank).getAmmunition().getBullet());
        assertEquals(99, ((SecurityTower) securityTower).getAmmunition().getBullet());
    }
}
