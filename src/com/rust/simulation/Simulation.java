package com.rust.simulation;

import com.rust.simulation.Entity.Grass;
import com.rust.simulation.Entity.Predator;
import com.rust.simulation.Entity.Prey;
import com.rust.simulation.Entity.Rock;

import java.util.HashMap;

public class Simulation {

    private WorldMap wm = new WorldMap(50, 20);
    private InitAction initAction = new InitAction();

    public void startSimulation() {
        while (true) {
            initAction.innitWM(wm, 10, 10, 10, 10);
            Renderer renderer = new Renderer(wm);
            renderer.renderMap();
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
