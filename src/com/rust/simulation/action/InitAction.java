package com.rust.simulation.action;

import com.rust.simulation.WorldMap;

public class InitAction extends Action {

    private WorldMap worldMap;
//    private int initAmountOfPredators;
//    private int initAmountOfPrey;
//    private int initAmountOfGrass;
//    private int initAmountOfRocks;

    public InitAction(WorldMap worldMap) {
        this.worldMap = worldMap;
//        this.initAmountOfPredators = initAmountOfPredators;
//        this.initAmountOfPrey = initAmountOfPrey;
//        this.initAmountOfGrass = initAmountOfGrass;
//        this.initAmountOfRocks = initAmountOfRocks;
    }



    public void innitWorldMap() {
        predatorFactory(worldMap, worldMap.getInitAmountOfPredators());
        preyFactory(worldMap, worldMap.getInitAmountOfPrey());
        grassFactory(worldMap, worldMap.getInitAmountOfGrass());
        rockFactory(worldMap, worldMap.getInitAmountOfRocks());
    }

//    public int getInitAmountOfPredators() {
//        return initAmountOfPredators;
//    }
//
//    public int getInitAmountOfPrey() {
//        return initAmountOfPrey;
//    }
//
//    public int getInitAmountOfGrass() {
//        return initAmountOfGrass;
//    }
//
//    public int getInitAmountOfRocks() {
//        return initAmountOfRocks;
//    }
}
