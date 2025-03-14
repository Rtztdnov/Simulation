package com.rust.simulation;

import com.rust.simulation.entity.*;

import java.util.*;

public class WorldMap {

    public static int column;
    public static int row;
    private HashMap<Coordinates, Entity> entitiesMap = new HashMap<>();
    private int initAmountOfPredators;
    private int initAmountOfPrey;
    private int initAmountOfGrass;
    private int initAmountOfRocks;

    public WorldMap(int column, int row, int initAmountOfPredators, int initAmountOfPrey,
                    int initAmountOfGrass, int initAmountOfRocks) {
        this.column = column;
        this.row = row;
        this.initAmountOfPredators = initAmountOfPredators;
        this.initAmountOfPrey = initAmountOfPrey;
        this.initAmountOfGrass = initAmountOfGrass;
        this.initAmountOfRocks = initAmountOfRocks;
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

    public int getInitAmountOfPredators() {
        return initAmountOfPredators;
    }

    public int getInitAmountOfPrey() {
        return initAmountOfPrey;
    }

    public int getInitAmountOfGrass() {
        return initAmountOfGrass;
    }

    public int getInitAmountOfRocks() {
        return initAmountOfRocks;
    }
}
