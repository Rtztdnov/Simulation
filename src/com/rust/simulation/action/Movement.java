package com.rust.simulation.action;

import com.rust.simulation.Coordinates;
import com.rust.simulation.WorldMap;
import com.rust.simulation.entity.*;

import java.util.*;

public class Movement {
    private WorldMap worldMap;
    private HashMap<Coordinates, Entity> entitiesMap;

    public Movement(WorldMap worldMap) {
        this.worldMap = worldMap;
        this.entitiesMap = worldMap.getEntitiesMap();
    }

    public void moveEntities() {
        int numberOfCreatures = getNumberOfCreatures();
        HashMap<Coordinates, Creature> movedCreatures = new HashMap<>();
        while (numberOfCreatures != movedCreatures.size()) {
            Set<Coordinates> entitiesCoordinates = entitiesMap.keySet();
            Iterator<Coordinates> iterator = entitiesCoordinates.iterator();
            Coordinates coordinates = null;
            Entity entity = null;
            while (iterator.hasNext()) {
                coordinates = iterator.next();
                entity = entitiesMap.get(coordinates);
                if (entitiesMap.get(coordinates) instanceof Creature && (!movedCreatures.containsKey(coordinates))) {
                    Creature creature = (Creature) entity;
                    Coordinates newCoordinates = creature.makeMove(coordinates, worldMap);
                    coordinates = newCoordinates;
                    movedCreatures.put(newCoordinates, (Creature) entity);
                    iterator.remove();
                    break;
                }
            }
            if (entity != null && coordinates != null) {
                entitiesMap.put(coordinates, entity);
            }else {
                throw new IllegalArgumentException("Null value detected");
            }
        }
    }

    private int getNumberOfCreatures() {
        int numberOfCreatures = 0;
        Set<Coordinates> entitiesCoordinates = entitiesMap.keySet();
        Iterator<Coordinates> iterator = entitiesCoordinates.iterator();
        while (iterator.hasNext()) {
            Coordinates coordinates = iterator.next();
            if (entitiesMap.get(coordinates) instanceof Creature) {
                numberOfCreatures++;
            }
        }
        return numberOfCreatures;
    }
}
