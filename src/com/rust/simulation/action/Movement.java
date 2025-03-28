package com.rust.simulation.action;

import com.rust.simulation.Coordinates;
import com.rust.simulation.WorldMap;
import com.rust.simulation.entity.*;

import java.util.*;

public class Movement {
    private WorldMap worldMap;

    public Movement(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void moveEntities() {
        int numberOfCreatures = worldMap.getNumberOfCreatures();
        HashMap<Coordinates, Creature> movedCreatures = new HashMap<>();
        while (numberOfCreatures != movedCreatures.size()) {
            Set<Coordinates> entitiesCoordinates = worldMap.getEntitiesMap().keySet();
            Iterator<Coordinates> iterator = entitiesCoordinates.iterator();
            Coordinates coordinates = null;
            Coordinates newCoordinates = null;
            Entity entity = null;
            while (iterator.hasNext()) {
                coordinates = iterator.next();
                entity = worldMap.getEntity(coordinates);
                if (worldMap.getEntitiesMap().get(coordinates) instanceof Creature && (!movedCreatures.containsKey(coordinates))) {
                    Creature creature = (Creature) entity;
                    newCoordinates = creature.getMove(coordinates, worldMap);
                    movedCreatures.put(newCoordinates, (Creature) entity);
                    break;
                }
            }
            worldMap.moveEntity(entity, coordinates, newCoordinates);
        }
    }
}
