package com.rust.simulation;

import com.rust.simulation.Entity.*;

import java.util.*;

public class WorldMap {

    private int column;
    private int row;
    private HashMap<Coordinates, Entity> entitiesMap = new HashMap<>();

    public WorldMap(int column, int row) {

        this.column = column;
        this.row = row;
    }

    public void entityFactory(Entity entity, int amount) {
        int counter = 0;
        while (counter < amount) {
            Coordinates coordinates = new Coordinates().getRandomCoordinates(column, row);
            if (!entitiesMap.containsKey(coordinates)) {
                entitiesMap.put(coordinates, entity);
                counter++;
            }
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setEntitiesMap(HashMap<Coordinates, Entity> entitiesMap) {
        this.entitiesMap = entitiesMap;
    }

    public HashMap<Coordinates, Entity> getWorldMap() {
        return entitiesMap;
    }
}
