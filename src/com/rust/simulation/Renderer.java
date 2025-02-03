package com.rust.simulation;

import com.rust.simulation.Entity.*;

import java.util.HashMap;

public class Renderer {

    private int maxRow;
    private int maxColumn;
    private WorldMap worldMap;
    private final String groundSprite = "\u2B1C";
    private final String predatorSprite = "\uD83E\uDD85";
    private final String preySprite = "\uD83D\uDC00";
    private final String rockSprite = "\u26F0";
    private final String grassSprite = "\uD83C\uDF3E";


    public Renderer(int maxRow, int maxColumn, WorldMap worldMap) {
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
        this.worldMap = worldMap;
    }

    public Renderer(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void renderMap() {
        HashMap<Coordinates, Entity> entities = worldMap.getWorldMap();
        StringBuilder line = new StringBuilder(groundSprite);

        while (true) {
            for (int row = 1; row <= maxRow; row++) {
                line.delete(0, line.length());
                for (int column = 1; column <= maxColumn; column++) {
                    Coordinates coordinates = new Coordinates(column, row);
                    if (entities.get(coordinates) instanceof Predator) {
                        line.append(predatorSprite);
                    } else if (entities.get(coordinates) instanceof Prey) {
                        line.append(preySprite);
                    } else if (entities.get(coordinates) instanceof Rock) {
                        line.append(rockSprite);
                    } else if (entities.get(coordinates) instanceof Grass) {
                        line.append(grassSprite);
                    } else {
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

