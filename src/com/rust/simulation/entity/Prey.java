package com.rust.simulation.entity;

import com.rust.simulation.BFSAlgorithm;
import com.rust.simulation.Coordinates;
import com.rust.simulation.WorldMap;

import java.util.*;

public class Prey extends Creature {

    public Prey(int speed, int hp, int power) {
        super(speed, hp, power);
    }

    @Override
    public void attack(LinkedList<Coordinates> way, WorldMap worldMap) {

        Coordinates target = way.getLast();
        if (worldMap.getEntitiesMap().get(target) instanceof Grass) {
            ((Grass) worldMap.getEntitiesMap().get(target)).takeDamage(getPower());
        }
    }

    @Override
    public Coordinates getMove(Coordinates coordinates, WorldMap worldMap) {

        BFSAlgorithm bfsAlgorithm = new BFSAlgorithm(worldMap);
        LinkedList<Coordinates> way = bfsAlgorithm.findTheWay(coordinates, Grass.class);

        return moving(coordinates, way, worldMap);
    }
}
