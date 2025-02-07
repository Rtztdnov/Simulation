package com.rust.simulation;

import java.util.Objects;
import java.util.Random;

public class Coordinates {

    private int column;
    private int row;

    public Coordinates(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public Coordinates() {
    }

    public Coordinates getRandomCoordinates(int column, int row) {
        Random random = new Random();
        Coordinates coordinates = new Coordinates(random.nextInt(column) + 1, random.nextInt(row) + 1);
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return column == that.column && row == that.row;
    }


    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
