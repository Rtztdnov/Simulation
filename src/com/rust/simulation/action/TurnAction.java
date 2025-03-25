package com.rust.simulation.action;

import com.rust.simulation.Coordinates;
import com.rust.simulation.entity.Damageable;
import com.rust.simulation.WorldMap;
import com.rust.simulation.entity.Entity;
import com.rust.simulation.entity.Grass;
import com.rust.simulation.entity.Predator;
import com.rust.simulation.entity.Prey;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class TurnAction extends Action {

    private WorldMap worldMap;
    private Movement movement;
    int amountOfPredators = 0;
    int amountOfPrey = 0;
    int amountOfGrass = 0;

    //    TODO исправить конструктор
    public TurnAction(WorldMap worldMap) {
        this.worldMap = worldMap;
        this.movement = new Movement(worldMap);
    }
    public void turn (){
        movement.moveEntities();
        removeCorpses();
        addMoreEntities();
    }

//    public TurnAction (WorldMap worldMap, int initAmountOfPredators, int initAmountOfPrey, int initAmountOfGrass, int initAmountOfRocks){
//        super(worldMap, initAmountOfPredators, initAmountOfPrey, initAmountOfGrass, initAmountOfRocks);
//    }
//


    private void countingEntities (){
        Collection<Entity> entities = worldMap.getEntitiesMap().values();
        for (Entity entity : entities) {
            if (entity instanceof Predator) {
                amountOfPredators++;
            }else if (entity instanceof Prey){
                amountOfPrey++;
            }else if (entity instanceof Grass){
                amountOfGrass++;
            }
        }
    }

    private void addMoreEntities (){
        countingEntities();
        if (amountOfPredators == 0){
            predatorFactory(worldMap, worldMap.getInitAmountOfPredators());
        }
        if (amountOfPrey == 0){
            preyFactory(worldMap, worldMap.getInitAmountOfPrey());
        }
        if (amountOfGrass == 0){
            grassFactory(worldMap, worldMap.getInitAmountOfGrass());
        }
        amountOfPredators = 0;
        amountOfPrey = 0;
        amountOfGrass = 0;

    }

    private void removeCorpses (){
        Set<Coordinates> entitiesCoordinates = worldMap.getEntitiesMap().keySet();
        Iterator<Coordinates> iterator = entitiesCoordinates.iterator();
        while (iterator.hasNext()) {
            Coordinates coordinates = iterator.next();
            if(worldMap.getEntitiesMap().get(coordinates) instanceof Damageable){
                if (((Damageable)worldMap.getEntitiesMap().get(coordinates)).getHp() < 0){
                    iterator.remove();
                }
            }
        }
    }
}
