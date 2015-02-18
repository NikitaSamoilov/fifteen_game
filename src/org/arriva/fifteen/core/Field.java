package org.arriva.fifteen.core;

import java.util.List;

public abstract class Field {

    protected int rowCount;
    protected int colCount;

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

    public abstract void scatterCells();
    public abstract List<Integer> getMobileCellRatings();
    public abstract RankingState getRankingState();
    public abstract void moveCell(int cellRating);

}
