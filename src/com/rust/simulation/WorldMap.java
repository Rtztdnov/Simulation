package com.rust.simulation;

import com.rust.simulation.Entity.*;

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

    public void setEntitiesMap(HashMap<Coordinates, Entity> entitiesMap) {
        this.entitiesMap = entitiesMap;
    }
}
