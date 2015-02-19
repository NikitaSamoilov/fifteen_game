package org.arriva.fifteen;


import org.arriva.fifteen.core.Die;
import org.arriva.fifteen.core.Field;

import java.util.List;

public abstract class FifteenGameHelper {
    public abstract void drawStep(Field field, List<Die> movableDies);
}
