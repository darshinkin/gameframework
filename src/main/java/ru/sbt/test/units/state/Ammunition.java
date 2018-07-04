package ru.sbt.test.units.state;

public class Ammunition {

    private int bullet;

    public Ammunition(int bullets) {
        this.bullet = bullets;
    }

    public int getBullet() {
        return bullet;
    }

    public void setBullet(int bullet) {
        this.bullet = bullet;
    }
}
