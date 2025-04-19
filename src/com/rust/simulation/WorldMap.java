package com.rust.simulation;

import com.rust.simulation.entity.*;

import java.util.*;

public class WorldMap {

    public static int column;
    public static int row;
    private HashMap<Coordinates, Entity> entitiesMap = new HashMap<>();

    public WorldMap(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public HashMap<Coordinates, Entity> getEntitiesMap() {
        return entitiesMap;
    }

    public Entity getEntity(Coordinates coordinates) {
        return entitiesMap.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        entitiesMap.remove(coordinates);
    }

    public void moveEntity(Entity entity, Coordinates from, Coordinates to) {
        removeEntity(from);
        addEntity(entity, to);
    }

    public void addEntity(Entity entity, Coordinates coordinates) {

        Objects.requireNonNull(entity, "Entity is Null");
        Objects.requireNonNull(coordinates, "Coordinates is Null");

            if (!entitiesMap.containsKey(coordinates)) {
                entitiesMap.put(coordinates, entity);
            } else {
                throw new IllegalArgumentException("Invalid coordinates");
            }
    }

    public void addEntityRandomCoordinates(Entity entity) {
        while (true) {
            Coordinates coordinates = new Coordinates().getRandomCoordinates(column, row);

            Objects.requireNonNull(entity, "Entity is Null");
            Objects.requireNonNull(coordinates, "Coordinates is Null");

                if (!entitiesMap.containsKey(coordinates)) {
                    entitiesMap.put(coordinates, entity);
                    break;
                }
        }
    }

    public int getNumberOfCreatures() {
        int numberOfCreatures = 0;
        Set<Coordinates> entitiesCoordinates = entitiesMap.keySet();
        Iterator<Coordinates> iterator = entitiesCoordinates.iterator();
        while (iterator.hasNext()) {
            Coordinates coordinates = iterator.next();
            if (entitiesMap.get(coordinates) instanceof Creature) {
                numberOfCreatures++;
            }
        }
        return numberOfCreatures;
    }
}
