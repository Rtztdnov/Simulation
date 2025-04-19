package com.rust.simulation.action;

import com.rust.simulation.WorldMap;

public class InitAction extends Action {

    private WorldMap worldMap;
    private int initAmountOfPredators;
    private int initAmountOfPrey;
    private int initAmountOfGrass;
    private int initAmountOfRocks;

    public InitAction(WorldMap worldMap, int initAmountOfPredators, int initAmountOfPrey,
                      int initAmountOfGrass, int initAmountOfRocks) {
        this.initAmountOfPredators = initAmountOfPredators;
        this.initAmountOfPrey = initAmountOfPrey;
        this.initAmountOfGrass = initAmountOfGrass;
        this.initAmountOfRocks = initAmountOfRocks;
        this.worldMap = worldMap;
        if ((initAmountOfPredators + initAmountOfPrey + initAmountOfGrass + initAmountOfRocks) >
                (worldMap.getColumn()) * worldMap.getRow()) {
            throw new IndexOutOfBoundsException("Amount of entities out of range");
        }
    }

    public void innitWorldMap() {
        predatorFactory(worldMap, initAmountOfPredators);
        preyFactory(worldMap, initAmountOfPrey);
        grassFactory(worldMap, initAmountOfGrass);
        rockFactory(worldMap, initAmountOfRocks);
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

}
