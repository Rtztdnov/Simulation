package com.rust.simulation;

import com.rust.simulation.Entity.Entity;

import java.util.HashMap;

public class Renderer {

    private final int maxRow;
    private final int maxColumn;
    private WorldMap worldMap;
    private final String groundSprite = "\u2B1C";
    private final String predatorSprite = "\uD83E\uDD85";


    public Renderer(int maxRow, int maxColumn, WorldMap worldMap) {
       this.maxRow = maxRow;
       this.maxColumn = maxColumn;
       this.worldMap = worldMap;
    }


    public void renderMap() {
        HashMap <Coordinates, Entity> predators = worldMap.getEntities();
        StringBuilder line = new StringBuilder(groundSprite);

        while (true) {
            for (int row = 1; row <= maxColumn; row++) {
                line.delete(0, line.length());
                for (int column = 1; column <= maxRow; column++) {
                    Coordinates coordinates = new Coordinates(column, row);
                    if (predators.containsKey(coordinates)) {
                        line.append(predatorSprite);
                    }else{
                    line.append(groundSprite);
                    }
                }
                System.out.println(line.toString());
            }
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}

