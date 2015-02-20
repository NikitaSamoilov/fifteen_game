package org.arriva.fifteen.impl;

import org.arriva.fifteen.FifteenGameHelper;
import org.arriva.fifteen.core.Die;
import org.arriva.fifteen.core.Field;

import java.util.List;

public class ConsoleFifteenGameHelper extends FifteenGameHelper {

    @Override
    public void drawStep(Field field, List<Die> movableDies) {
        System.out.println(field.fieldAsString());

        System.out.println("Choose die to move:");
        for (int i = 0; i < movableDies.size(); i++) {
            System.out.println(String.format("%d. %d ", i + 1, movableDies.get(i).getRating()));
        }
    }
}
