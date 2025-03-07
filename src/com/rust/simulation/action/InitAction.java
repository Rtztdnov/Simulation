package com.rust.simulation.action;

import com.rust.simulation.WorldMap;

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
