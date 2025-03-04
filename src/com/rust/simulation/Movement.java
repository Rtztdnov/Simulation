package com.rust.simulation;

import com.rust.simulation.Entity.*;

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
                    try {
                    movedCreatures.put(newCoordinates, (Creature) entity);
                    iterator.remove();
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
            }
            try {
            entitiesMap.put(coordinates, entity);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        removeCorpses();
//        worldMap.setEntitiesMap(entitiesMap);
    }

    public void removeCorpses (){
        Set<Coordinates> entitiesCoordinates = entitiesMap.keySet();
        Iterator<Coordinates> iterator = entitiesCoordinates.iterator();
        while (iterator.hasNext()) {
            Coordinates coordinates = iterator.next();
            if(entitiesMap.get(coordinates) instanceof Creature){
                if (((Creature) entitiesMap.get(coordinates)).getHp() < 0){
                    iterator.remove();
                }
            }else if(entitiesMap.get(coordinates) instanceof Grass){
                if (((Grass) entitiesMap.get(coordinates)).getHP() < 0){
                    iterator.remove();
                }
            }
        }
    }

    public int getNumberOfCreatures() {
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
