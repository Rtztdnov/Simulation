package com.rust.simulation;

import com.rust.simulation.action.InitAction;
import com.rust.simulation.action.Movement;
import com.rust.simulation.action.TurnAction;

public class Simulation {


    public void startSimulation() {
        WorldMap worldMap = new WorldMap(50, 20,3,20,40,15);
        InitAction initAction = new InitAction(worldMap);
        initAction.innitWorldMap();
//        Movement movement = new Movement(worldMap);
        TurnAction turnAction = new TurnAction(worldMap);
        while (true) {
            Renderer renderer = new Renderer(worldMap);
            renderer.renderMap();
            System.out.println();
//            movement.moveEntities();
            turnAction.turn();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
