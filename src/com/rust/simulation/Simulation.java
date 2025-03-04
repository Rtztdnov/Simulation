package com.rust.simulation;

public class Simulation {


    public void startSimulation() {
        WorldMap worldMap = new WorldMap(20, 20);
        InitAction initAction = new InitAction(worldMap);
        initAction.innitWorldMap(2,6,7,5);

        Movement movement = new Movement(worldMap);
        while (true) {
            Renderer renderer = new Renderer(worldMap);
            renderer.renderMap();
            System.out.println();
            movement.moveEntities();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
