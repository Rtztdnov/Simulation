package com.rust.simulation.Entity;

import com.rust.simulation.Coordinates;
import com.rust.simulation.WorldMap;

import java.util.LinkedList;

public abstract class Creature extends Entity {

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
}
