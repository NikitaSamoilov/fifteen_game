package org.arriva.fifteen;

import org.arriva.fifteen.core.Die;
import org.arriva.fifteen.core.Field;
import org.arriva.fifteen.core.RankingState;
import org.arriva.fifteen.core.impl.TrivialField;
import org.arriva.fifteen.impl.ConsoleFifteenGameHelper;

import java.util.List;
import java.util.Scanner;

public class FifteenGame {

    static FifteenGameHelper helper = new ConsoleFifteenGameHelper();

    public static void main(String[] args) {
        Field field = new TrivialField(4, 4);
        List<Die> diesToMove = field.getMobileDies();
        Scanner scanner = new Scanner(System.in);

        helper.drawStep(field, diesToMove);

        while (field.getRankingState() != RankingState.Order && scanner.hasNextLine()) {
            if (scanner.hasNextInt()) {
                int choosedDieNumber = scanner.nextInt();
                if (choosedDieNumber > 0 && choosedDieNumber <= diesToMove.size()) {
                    field.moveDie(diesToMove.get(choosedDieNumber - 1));
                }
            } else {
                break;
            }
            diesToMove = field.getMobileDies();
            helper.drawStep(field, diesToMove);

        }
    }
}
