package com.rust.simulation;

import com.rust.simulation.Entity.*;

import java.util.*;

public class WorldMap {

    private int predatorAmount;
    private int preyAmount;
    private int rockAmount;
    private int grassAmount;
    private int row;
    private int column;
    private HashMap <Coordinates, Entity> entities = new HashMap<>();

    public WorldMap(int row, int column, int predatorAmount, int preyAmount, int rockAmount, int grassAmount) {
        this.predatorAmount = predatorAmount;
        this.preyAmount = preyAmount;
        this.rockAmount = rockAmount;
        this.grassAmount = grassAmount;

        this.row = row;
        this.column = column;
        innitWM();
    }

    public WorldMap() {

    }

    private void innitWM() {
        entityFactory(new Predator(), predatorAmount);
        entityFactory(new Prey(), preyAmount);
        entityFactory(new Rock(), rockAmount);
        entityFactory(new Grass(), grassAmount);


    }

    public void entityFactory(Entity entity, int amount) {
        int counter = 0;
        while (counter < amount) {
            Coordinates coordinates = getRandCoordinates();
            if (!entities.containsKey(coordinates)) {
                entities.put(coordinates, entity);
                counter++;
            } else {
                coordinates = null;
            }
        }
    }

    private Coordinates getRandCoordinates() {
        Random random = new Random();
        Coordinates coordinates = new Coordinates(random.nextInt(column) + 1, random.nextInt(row) + 1);
        return coordinates;
    }

    public HashMap<Coordinates, Entity> getWorldMap() {
        return entities;
    }
}
