package com.rust.simulation.entity;

import com.rust.simulation.BFSAlgorithm;
import com.rust.simulation.Coordinates;
import com.rust.simulation.WorldMap;

import java.util.*;

public class Predator extends Creature {

    public Predator(int speed, int hp, int power) {
        super(speed, hp, power);
    }

    @Override
    public void attack(LinkedList<Coordinates> way, WorldMap worldMap) {

        Coordinates target = way.getLast();
        if (worldMap.getEntitiesMap().get(target) instanceof Prey) {
            ((Prey) worldMap.getEntitiesMap().get(target)).takeDamage(getPower());
        }
    }

    @Override
    public Coordinates getMove(Coordinates coordinates, WorldMap worldMap) {

        BFSAlgorithm bfsAlgorithm = new BFSAlgorithm(worldMap);
        LinkedList<Coordinates> way = bfsAlgorithm.findTheWay(coordinates, Prey.class);

        return moving(coordinates, way, worldMap);
    }
}
