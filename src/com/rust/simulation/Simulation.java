package com.rust.simulation;

import com.rust.simulation.action.InitAction;
import com.rust.simulation.action.Movement;
import com.rust.simulation.action.TurnAction;

public class Simulation {

    WorldMap worldMap = new WorldMap(10, 10);
    InitAction initAction = new InitAction(worldMap, 1, 2, 3, 4);
    TurnAction turnAction = new TurnAction(worldMap, initAction);
    Renderer renderer = new Renderer(worldMap);
    private volatile boolean running = true;

    public Simulation() {
        initAction.innitWorldMap();
    }

    public void startSimulation() {
        while (true) {
            try {
                synchronized (this) {
                    while (!running) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Поток прерван");
            }
            nextTurn(turnAction, worldMap, renderer);
            System.out.println("RUN");
        }
    }

    private void nextTurn(TurnAction turnAction, WorldMap worldMap, Renderer renderer) {
        renderer.renderMap();
        System.out.println();
        turnAction.turn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public synchronized void pauseSimulation() {
        running = false;
        notify();
    }

    public synchronized void resumeSimulation() {
        running = true;
        notify();
    }
}
