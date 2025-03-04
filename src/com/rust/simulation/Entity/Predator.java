package com.rust.simulation.Entity;

import com.rust.simulation.BfsAlgorithm;
import com.rust.simulation.Coordinates;
import com.rust.simulation.WorldMap;

import java.util.*;

public class Predator extends Creature {

    public Predator(int speed, int hp, int power){
        super(speed, hp, power);
    }

    public void attack (LinkedList<Coordinates> way, WorldMap worldMap) {
        Coordinates target = way.getLast();
        if (worldMap.getEntitiesMap().get(target) instanceof Prey){
           ((Prey) worldMap.getEntitiesMap().get(target)).takeDamage(getPower());
        }

        System.out.println("ATTACKING");
    }

    @Override
    public Coordinates makeMove(Coordinates coordinates, WorldMap worldMap) {
        BfsAlgorithm bfsAlgorithm = new BfsAlgorithm();
        LinkedList<Coordinates> way = bfsAlgorithm.findTheWay(coordinates, worldMap, Prey.class);
        if (way.isEmpty()) {
            return coordinates;
        } else if ((way.size() == getSpeed() + 1) || (way.size() == 2)) {
            attack(way, worldMap);
            return coordinates;
        } else {
            return way.get(getSpeed());
        }
    }
}
