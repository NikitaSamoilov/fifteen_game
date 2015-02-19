package org.arriva.fifteen.core.impl;

import org.arriva.fifteen.core.Die;
import org.arriva.fifteen.core.DieProperty;
import org.arriva.fifteen.core.Field;
import org.arriva.fifteen.core.FieldHelper;

public class TrivialFieldHelper extends FieldHelper {


    public TrivialFieldHelper(TrivialField field) {
        super(field);
    }

    @Override
    public Die initDieInField(int row, int col, int rating) {
        DieProperty property = new DieProperty();
        property.row = row;
        property.col = col;
        property.rating = rating;
        return new TrivialDie(field, property);
    }
}
