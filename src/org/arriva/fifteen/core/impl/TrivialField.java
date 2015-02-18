package org.arriva.fifteen.core.impl;

import org.arriva.fifteen.core.*;

import java.util.*;


public class TrivialField extends Field {

    protected RankingState rankingState;
    protected Die[][] dies;


    public TrivialField(int rowCount, int colCount) {
        super(rowCount, colCount);
        fieldHelper = new TrivialFieldHelper(this);
        dies = new Die[rowCount][colCount];
        scatterCells();
        rankingState = RankingState.Disorder;
    }


    @Override
    public void scatterCells() {
        // TODO: It's awful and incorrect - remake
        List<Integer> raitings = fieldHelper.getShuffledRaitings(rowCount * colCount - 1);

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                dies[i][j] = fieldHelper.initDieInField(i, j, raitings.get(i * colCount + j));
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

}
