package com.rust.simulation;

import com.rust.simulation.Entity.*;

import java.util.HashMap;

public class InitAction extends Action {

    private WorldMap worldMap;

    public InitAction(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void innitWorldMap(int predatorAmount, int preyAmount, int grassAmount, int rockAmount) {
        predatorFactory(worldMap, predatorAmount);
        preyFactory(worldMap, preyAmount);
        grassFactory(worldMap, grassAmount);
        rockFactory(worldMap, rockAmount);
    }
}
