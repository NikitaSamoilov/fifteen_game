package org.arriva.fifteen.core.impl;

import org.arriva.fifteen.core.*;

import java.util.*;


public class TrivialField extends Field {

    protected RankingState rankingState;
    protected Die[][] dies;
    protected Die emptyCell;


    public TrivialField(int rowCount, int colCount) {
        super(rowCount, colCount);
        fieldHelper = new TrivialFieldHelper(this);
        dies = new Die[rowCount][colCount];
        scatterDies();
        rankingState = RankingState.Disorder;
    }


    @Override
    public void scatterDies() {
        List<Integer> raitings = fieldHelper.getShuffledRaitings(rowCount * colCount - 1);

        for (int i = 0; i < raitings.size(); i++) {
            int row = i / colCount;
            int col = i - (row * colCount);
            dies[row][col] = fieldHelper.initDieInField(row, col, raitings.get(i));
        }

        dies[rowCount - 1][colCount - 1] = fieldHelper.initDieInField(rowCount - 1, colCount - 1, SpecialDieRatings.EMPTY_CELL_RATING);
        emptyCell = dies[rowCount - 1][colCount - 1];
    }

    @Override
    public List<Die> getMobileDieRatings() {
        List<Die> neighborDies = Collections.EMPTY_LIST;

        if (emptyCell.getRow() > 0) {
            neighborDies.add(dies[emptyCell.getRow() - 1][emptyCell.getCol()]);
        }

        if (emptyCell.getRow() < rowCount - 1) {
            neighborDies.add(dies[emptyCell.getRow() + 1][emptyCell.getCol()]);
        }

        if (emptyCell.getCol() > 0) {
            neighborDies.add(dies[emptyCell.getRow()][emptyCell.getCol() - 1]);
        }

        if (emptyCell.getCol() < colCount - 1) {
            neighborDies.add(dies[emptyCell.getRow()][emptyCell.getCol() + 1]);
        }

        return neighborDies;
    }

    @Override
    public RankingState getRankingState() {
        return rankingState;
    }

    @Override
    public void moveDie(Die die) {
        emptyCell.setRating(die.getRating());
        die.setRating(SpecialDieRatings.EMPTY_CELL_RATING);
        emptyCell = die;
    }

    @Override
    public String fieldAsString() {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                strBuilder.append(String.valueOf(dies[i][j].getRating()) + "\t");
            }
            strBuilder.append("\n");
        }

        return strBuilder.toString();
    }

}
