package com.rust.simulation;

import com.rust.simulation.entity.*;

import java.util.HashMap;

public class Renderer {

    private int maxColumn;
    private int maxRow;
    private WorldMap worldMap;
    private final String groundSprite = "\u2B1C";  	//black square "\u2B1B"
    private final String predatorSprite = "\uD83E\uDD85";
    private final String preySprite = "\uD83D\uDC00";
    private final String rockSprite = "\uD83E\uDEA8";
    private final String grassSprite = "\uD83C\uDF3E";

    public Renderer(WorldMap worldMap) {
        this.worldMap = worldMap;
        this.maxColumn = worldMap.getColumn();
        this.maxRow = worldMap.getRow();
    }

    public void renderMap() {
        HashMap<Coordinates, Entity> entities = worldMap.getEntitiesMap();
        StringBuilder line = new StringBuilder(groundSprite);

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
    }

}

