package com.rust.simulation.entity;

public class Grass extends Entity {

    private int HP = 1;

    public void takeDamage(int damage) {
        HP -= damage;
    }

    public int getHP() {
        return HP;
    }
}
