package org.arriva.fifteen.core;

import java.util.List;

public abstract class Field {

    protected int rowCount;
    protected int colCount;
    protected FieldHelper fieldHelper;

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public Field(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    public abstract void scatterDies();
    public abstract List<Die> getMobileDieRatings();
    public abstract RankingState getRankingState();
    public abstract void moveDie(Die die);

}
