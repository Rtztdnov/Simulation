package com.rust.simulation;
import com.rust.simulation.Entity.*;

import java.util.HashMap;

public class WorldMap {

    private HashMap <Coordinates, Entity> entities = new HashMap<>();


    public WorldMap() {
        predatorFactory (new Coordinates(1, 1), new Predator());
    }



    private void predatorFactory (Coordinates coordinates, Predator predator) {
        entities.put(coordinates, predator);
    }

    public HashMap<Coordinates, Entity> getEntities() {
        return entities;
    }
}