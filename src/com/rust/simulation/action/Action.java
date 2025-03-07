package com.rust.simulation.action;

import com.rust.simulation.Coordinates;
import com.rust.simulation.WorldMap;
import com.rust.simulation.entity.*;

public class Action {

    public void predatorFactory (WorldMap worldMap, int amount) {
        for (int i = 0; i < amount; i++) {
            Predator predator = new Predator(2, 100, 50);
            addEntity(worldMap, predator);
        }
    }

    public void preyFactory (WorldMap worldMap, int amount) {
        for (int i = 0; i < amount; i++) {
            Prey prey = new Prey(1, 100, 1);
            addEntity(worldMap, prey);
        }
    }

    public void grassFactory (WorldMap worldMap, int amount) {
        for (int i = 0; i < amount; i++) {
            Grass grass = new Grass();
            addEntity(worldMap, grass);
        }
    }

    public void rockFactory (WorldMap worldMap, int amount) {
        for (int i = 0; i < amount; i++) {
            Rock rock = new Rock();
            addEntity(worldMap, rock);
        }
    }

    public void addEntity (WorldMap worldMap, Entity entity) {
        Coordinates coordinates = new Coordinates().getRandomCoordinates(worldMap.getColumn(), worldMap.getRow());
        if (!worldMap.getEntitiesMap().containsKey(coordinates)) {
            worldMap.getEntitiesMap().put(coordinates, entity);
        }
    }
}
