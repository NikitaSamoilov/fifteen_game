package org.arriva.fifteen.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class FieldHelper {
    protected Field field;

    public FieldHelper(Field field) {
        this.field = field;
    }

    public List<Integer> getShuffledRaitings(int count) {
        List<Integer> values = new ArrayList<Integer>();

        for (int i = 0; i < count; i++) {
            values.add(i + 1);
        }
        Collections.shuffle(values);
        return values;
    }

    public abstract Die initDieInField(int row, int col, int rating);
}
