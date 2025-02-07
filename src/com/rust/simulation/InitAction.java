package com.rust.simulation;

import com.rust.simulation.Entity.*;

public class InitAction {

    public void innitWM(WorldMap worldMap, int predatorAmount, int preyAmount, int rockAmount, int grassAmount) {
        worldMap.entityFactory(new Predator(), predatorAmount);
        worldMap.entityFactory(new Prey(), preyAmount);
        worldMap.entityFactory(new Rock(), rockAmount);
        worldMap.entityFactory(new Grass(), grassAmount);
    }
}
