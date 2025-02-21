package com.rust.simulation;

import com.rust.simulation.Entity.*;

import java.util.HashMap;

public class InitAction {

    private WorldMap worldMap;
    private HashMap<Coordinates, Entity> entitiesMap;

    public InitAction(WorldMap worldMap) {
        this.worldMap = worldMap;
        this.entitiesMap = worldMap.getEntitiesMap();
    }

    public void innitWorldMap(int predatorAmount, int preyAmount, int grassAmount, int rockAmount) {
        entityFactory(new Predator(), predatorAmount);
        entityFactory(new Prey(), preyAmount);
        entityFactory(new Grass(), grassAmount);
        entityFactory(new Rock(), rockAmount);
    }
    public void entityFactory (Entity entity, int amount) {
        int counter = 0;
        while (counter < amount) {
            Coordinates coordinates = new Coordinates().getRandomCoordinates(worldMap.getColumn(), worldMap.getRow());
//            Coordinates coordinates = new Coordinates().getRandomCoordinates(WorldMap.column, WorldMap.row);
            if (!entitiesMap.containsKey(coordinates)) {
                entitiesMap.put(coordinates, entity);
                counter++;
            }
        }
    }
//    public <T> HashMap <Coordinates, T> entityFactory (T t, int amount) {
//        HashMap <Coordinates, T> someEntityMap = new HashMap<>();
//        HashMap <Coordinates, Entity> entitiesMap = worldMap.getEntitiesMap();
//
//        int counter = 0;
//        while (counter < amount) {
//            Coordinates coordinates = new Coordinates().getRandomCoordinates(worldMap.getColumn(), worldMap.getRow());
//            if (!entitiesMap.containsKey(coordinates) && !someEntityMap.containsKey(coordinates)) {
//                someEntityMap.put(coordinates, t);
//                counter++;
//            }
//        }
//        return someEntityMap;
//    }
}
