package com.rust.simulation.entity;

import com.rust.simulation.Coordinates;
import com.rust.simulation.WorldMap;

import java.util.LinkedList;

public abstract class Creature extends Entity implements Damageable {

    private int speed;
    private int hp;
    private int power;

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public int getPower() {
        return power;
    }

    public Creature(int speed, int hp, int power) {
        this.speed = speed;
        this.hp = hp;
        this.power = power;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public abstract Coordinates makeMove(Coordinates coordinates, WorldMap worldMap);

    public abstract void attack(LinkedList<Coordinates> way, WorldMap worldMap);

    public Coordinates moving (Coordinates coordinates, LinkedList<Coordinates> way, WorldMap worldMap) {

        if (way.isEmpty()) {
            return coordinates;
        } else if ((way.size() == getSpeed() + 1) || (way.size() == 2)) {
            attack(way, worldMap);
            return coordinates;
        } else {
            return way.get(getSpeed());
        }
    }
}
