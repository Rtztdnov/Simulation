package com.rust.simulation;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        Menu menu = new Menu(simulation);
        if (menu.starting()) {
            simulation.startSimulation();
        }
    }
}