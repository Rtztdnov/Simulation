package com.rust.simulation.action;

import com.rust.simulation.WorldMap;
import com.rust.simulation.entity.*;

public abstract class Action {

    public void predatorFactory (WorldMap worldMap, int amount) {
        for (int i = 0; i < amount; i++) {
            Predator predator = new Predator(1, 100, 100);
            worldMap.addEntityRandomCoordinates(predator);
        }
    }

    public void preyFactory (WorldMap worldMap, int amount) {
        for (int i = 0; i < amount; i++) {
            Prey prey = new Prey(1, 100, 1);
            worldMap.addEntityRandomCoordinates(prey);
        }
    }

    public void grassFactory (WorldMap worldMap, int amount) {
        for (int i = 0; i < amount; i++) {
            Grass grass = new Grass();
            worldMap.addEntityRandomCoordinates(grass);
        }
    }

    public void rockFactory (WorldMap worldMap, int amount) {
        for (int i = 0; i < amount; i++) {
            Rock rock = new Rock();
            worldMap.addEntityRandomCoordinates(rock);
        }
    }
}
