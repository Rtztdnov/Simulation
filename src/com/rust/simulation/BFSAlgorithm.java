package com.rust.simulation;

import com.rust.simulation.entity.Entity;

import java.util.*;

public class BFSAlgorithm {

    WorldMap worldMap;

    public BFSAlgorithm(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public <Food> LinkedList<Coordinates> findTheWay(Coordinates firstCoordinate, Class<Food> food) {
        HashMap<Coordinates, Entity> entitiesMap = worldMap.getEntitiesMap();
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        HashMap<Coordinates, Coordinates> inheritorChain = new HashMap<>();
        queue.add(firstCoordinate);
        while ((!queue.isEmpty())) {
            Coordinates currentCoordinates = queue.poll();
            ArrayList<Coordinates> neighbours = getneighbours(currentCoordinates);
            for (Coordinates c : neighbours) {
                if (!visited.contains(c)) {
                    visited.add(currentCoordinates);
                    if (!inheritorChain.containsKey(c)) {
                        inheritorChain.put(c, currentCoordinates);
                        if (entitiesMap.containsKey(c)) {
                            if (food.isInstance(entitiesMap.get(c))) {
                                return getWay(inheritorChain, firstCoordinate, c);
                            }
                        } else {
                            queue.add(c);
                        }
                    }
                }
            }
        }
        LinkedList<Coordinates> emptyWay = new LinkedList<>();
        return emptyWay;
    }

    private LinkedList<Coordinates> getWay(HashMap<Coordinates, Coordinates> inheritorChain,
                                           Coordinates start,
                                           Coordinates end) {
        LinkedList<Coordinates> way = new LinkedList<>();
        while (!start.equals(end)) {
            way.addFirst(end);
            end = inheritorChain.get(end);
        }
        way.addFirst(start);
        return way;
    }

    private ArrayList<Coordinates> getneighbours(Coordinates coordinates) {
        ArrayList<Coordinates> neighbours = new ArrayList<>();
        int column = coordinates.getColumn();
        int row = coordinates.getRow();

        Coordinates neighbour1 = new Coordinates(column - 1, row - 1);
        neighbours.add(neighbour1);
        Coordinates neighbour2 = new Coordinates(column, row - 1);
        neighbours.add(neighbour2);
        Coordinates neighbour3 = new Coordinates(column + 1, row - 1);
        neighbours.add(neighbour3);
        Coordinates neighbour4 = new Coordinates(column - 1, row);
        neighbours.add(neighbour4);
        Coordinates neighbour5 = new Coordinates(column + 1, row);
        neighbours.add(neighbour5);
        Coordinates neighbour6 = new Coordinates(column - 1, row + 1);
        neighbours.add(neighbour6);
        Coordinates neighbour7 = new Coordinates(column, row + 1);
        neighbours.add(neighbour7);
        Coordinates neighbour8 = new Coordinates(column + 1, row + 1);
        neighbours.add(neighbour8);

        Iterator<Coordinates> iterator = neighbours.iterator();
        while (iterator.hasNext()) {
            Coordinates currentCoordinates = iterator.next();
            if (!isInRange(currentCoordinates)) {
                iterator.remove();
            }
        }
        return neighbours;
    }

    private boolean isInRange(Coordinates coordinates) {
        int column = coordinates.getColumn();
        int row = coordinates.getRow();
        int maxColumn = worldMap.getColumn();
        int maxRow = worldMap.getRow();
        boolean inRange;
        if (1 <= column && column <= maxColumn && 1 <= row && row <= maxRow) {
            inRange = true;
        } else {
            inRange = false;
        }
        return inRange;
    }
}
