package com.rust.simulation.Entity;

import com.rust.simulation.Coordinates;
import com.rust.simulation.WorldMap;

public abstract class Creature extends Entity {

    public abstract Coordinates makeMove(Coordinates coordinates, WorldMap worldMap);
}
