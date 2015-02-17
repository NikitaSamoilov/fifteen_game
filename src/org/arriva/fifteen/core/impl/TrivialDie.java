package org.arriva.fifteen.core.impl;

import org.arriva.fifteen.core.Die;
import org.arriva.fifteen.core.Field;


public class TrivialDie extends Die {

    public TrivialDie(Field parentField, int rating, int row, int col) {
        super(parentField, rating, row, col);
    }

    @Override
    public void moveUp() {
        if (row == 0) {
            throw new IllegalStateException("Die cannot move upper");
        }

        row -= 1;
    }

    @Override
    public void moveDown() {
        if (row == parentField.getRowCount() - 1) {
            throw new IllegalStateException("Die cannot move downer");
        }

        row += 1;
    }

    @Override
    public void moveLeft() {
        if (col == 0) {
            throw new IllegalStateException("Die cannot move left");
        }

        col -= 1;
    }

    @Override
    public void moveRight() {
        if (col == parentField.getColCount() - 1) {
            throw new IllegalStateException("Die cannot move right");
        }

        col += 1;
    }
}
