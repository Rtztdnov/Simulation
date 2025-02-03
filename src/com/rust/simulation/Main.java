package com.rust.simulation;

import com.rust.simulation.Entity.Entity;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int column = 30;
        int row = 20;
        WorldMap wm = new WorldMap(row, column, 10, 10, 10, 10);
        Renderer renderer = new Renderer(row, column, wm);
        renderer.renderMap();

    }
}