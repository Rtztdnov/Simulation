package com.rust.simulation.action;

import com.rust.simulation.Coordinates;
import com.rust.simulation.WorldMap;
import com.rust.simulation.entity.*;

public abstract class Action {

    public void predatorFactory (WorldMap worldMap, int amount) {
        for (int i = 0; i < amount; i++) {
            Predator predator = new Predator(2, 100, 100);
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
//            Rock rock = null;
            Rock rock = new Rock();
            addEntity(worldMap, rock);
        }
    }

    public void addEntity (WorldMap worldMap, Entity entity) {
        while (true){
            Coordinates coordinates = new Coordinates().getRandomCoordinates(worldMap.getColumn(), worldMap.getRow());
            if (entity != null && coordinates != null) {
                if (!worldMap.getEntitiesMap().containsKey(coordinates)) {
                    worldMap.getEntitiesMap().put(coordinates, entity);
                    break;
                }
            }else {
                throw new IllegalArgumentException("Null value detected");
            }

        }

    }
}
