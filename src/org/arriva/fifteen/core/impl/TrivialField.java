package org.arriva.fifteen.core.impl;

import org.arriva.fifteen.core.*;

import java.math.BigInteger;
import java.util.*;


public class TrivialField extends Field {

    protected RankingState rankingState;
    protected Die[][] dies;


    public TrivialField(int rowCount, int colCount) {
        super(rowCount, colCount);
        dies = new Die[rowCount][colCount];
        scatterCells();
        rankingState = RankingState.Disorder;
    }


    @Override
    public void scatterCells() {
        // TODO: It's awful and incorrect - remake
        List<Integer> raitings = getShuffledRaitings(rowCount * colCount - 1);

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                dies[i][j] = initDie(i, j, raitings.get(i * colCount + j));
            }
        }
    }

    @Override
    public List<Integer> getMobileCellRatings() {
        return null; // TODO: Implement logic
    }

    @Override
    public RankingState getRankingState() {
        return rankingState;
    }

    @Override
    public void moveCell(int cellRating) {
        // TODO: Implement logic
    }

    private Die initDie(int row, int col, int rating) {
        DieProperty property = new DieProperty();
        property.row = row;
        property.col = col;
        property.rating = rating;
        return new TrivialDie(this, property);
    }

    private List<Integer> getShuffledRaitings(int count) {
        List<Integer> values = new ArrayList<Integer>();

        for (int i = 0; i < count; i++) {
            values.add(i + 1);
        }
        Collections.shuffle(values);
        return values;
    }
}
