package com.training.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Perform function of storing information of turns and
 * forming statistic for user in string format, using data of
 * turns.
 *
 * @author Liakhovetskyi Bohdan
 */
public class Statistic {

    /* Constants */
    private static final String STATISTIC_FORMAT = "Turn %d: range[%d, %d] your input %d. Result: %s";
    private static final String WRONG_WORD = "wrong";
    private static final String RIGHT_WORD = "right";

    /* Storage of turn objects */
    private List<Turn> userTurns = new ArrayList<>();

    /* Constructor */
    public Statistic() {

    }

    /**
     * Forming {@code Turn} instance from input data and
     * adding this instance to list of instances
     *
     * @param minRequired value of min required number in range
     * @param maxRequired value of max required number in range
     * @param userTurn    user input value
     * @param result      is this turn victorious or not
     */
    public void addInfo(int minRequired, int maxRequired, int userTurn, boolean result) {
        Turn turn = new Turn(minRequired, maxRequired, userTurn, result);
        userTurns.add(turn);
    }

    /**
     * Forming statistics in string specific format
     * to output it through the console
     *
     * @return text of statistic
     */
    public String formStatistic() {
        StringBuilder stringBuilder = new StringBuilder();
        String resultStatus;

        for (Turn turn : userTurns) {
            stringBuilder.append(String.format(formStatisticOfTurn(turn)));
        }

        return stringBuilder.toString();
    }

    private String formStatisticOfTurn(Turn turn) {
        String statisticOfTurn = String.format(STATISTIC_FORMAT, turn.getNumberOfTurn(), turn.getMinNumberRequired(),
                turn.getMaxNumberRequired(), turn.getUserInput(), getResultStatusOfTurn(turn));
        statisticOfTurn = statisticOfTurn.concat(System.lineSeparator());

        return statisticOfTurn;
    }

    private String getResultStatusOfTurn(Turn turn) {
        return turn.isWinningMove() ? RIGHT_WORD : WRONG_WORD;
    }
}
