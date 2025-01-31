package com.rust.simulation;

import com.rust.simulation.Entity.Entity;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Renderer renderer = new Renderer(10, 10, new WorldMap());
        renderer.renderMap();

    }
}