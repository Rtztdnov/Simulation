package com.rust.simulation;

import com.rust.simulation.action.InitAction;
import com.rust.simulation.action.Movement;
import com.rust.simulation.action.TurnAction;

public class Simulation {

    public void startSimulation() {
        WorldMap worldMap = new WorldMap(10, 10);
        InitAction initAction = new InitAction(worldMap,1,2,3,4);
        initAction.innitWorldMap();
        TurnAction turnAction = new TurnAction(worldMap, initAction);
        while (true) {
            Renderer renderer = new Renderer(worldMap);
            renderer.renderMap();
            System.out.println();
            turnAction.turn();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
