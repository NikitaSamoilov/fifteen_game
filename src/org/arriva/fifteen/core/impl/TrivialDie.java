package org.arriva.fifteen.core.impl;

import org.arriva.fifteen.core.Die;
import org.arriva.fifteen.core.DieProperty;
import org.arriva.fifteen.core.Field;


public class TrivialDie extends Die {

    public TrivialDie(Field parentField, DieProperty property) {
        super(parentField, property);
    }

    @Override
    public void moveUp() {
        if (property.row == 0) {
            throw new IllegalStateException("Die cannot move upper");
        }

        property.row -= 1;
    }

    @Override
    public void moveDown() {
        if (property.row == parentField.getRowCount() - 1) {
            throw new IllegalStateException("Die cannot move downer");
        }

        property.row += 1;
    }

    @Override
    public void moveLeft() {
        if (property.col == 0) {
            throw new IllegalStateException("Die cannot move left");
        }

        property.col -= 1;
    }

    @Override
    public void moveRight() {
        if (property.col == parentField.getColCount() - 1) {
            throw new IllegalStateException("Die cannot move right");
        }

        property.col += 1;
    }
}
