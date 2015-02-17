package org.arriva.fifteen.core;

public abstract class Die {

    protected int rating;
    protected int row;
    protected int col;

    public int getRating() {
        return rating;
    }

    public int getRow() {
        return row;
    }


    public int getCol() {
        return col;
    }


    public Die(int rating, int row, int col) {
        this.rating = rating;
    }


    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();

}
