package com.training.model;

/**
 * Turn entity. Represents entity of user turn in game
 *
 * @author Liakhovetskyi Bohdan
 */
public class Turn {

    /* Primary key for changing numberOfTurn*/
    private static int autoIncrement = 0;

    /* Local variables */
    private int numberOfTurn;
    private int minNumberRequired;
    private int maxNumberRequired;
    private int userInput;
    private boolean winningMove;

    /* Constructor */
    public Turn(int minNumberOnTurn, int maxNumberOnTurn, int userInput, boolean result) {
        this.numberOfTurn = ++autoIncrement;
        this.minNumberRequired = minNumberOnTurn;
        this.maxNumberRequired = maxNumberOnTurn;
        this.userInput = userInput;
        this.winningMove = result;
    }

    /* Getters and setters */

    public int getNumberOfTurn() {
        return this.numberOfTurn;
    }

    public void setNumberOfTurn(int numberOfTurn) {
        this.numberOfTurn = numberOfTurn;
    }

    public int getMinNumberRequired() {
        return minNumberRequired;
    }

    public void setMinNumberRequired(int minNumberRequired) {
        this.minNumberRequired = minNumberRequired;
    }

    public int getMaxNumberRequired() {
        return maxNumberRequired;
    }

    public void setMaxNumberRequired(int maxNumberRequired) {
        this.maxNumberRequired = maxNumberRequired;
    }

    public int getUserInput() {
        return userInput;
    }

    public void setUserInput(int userInput) {
        this.userInput = userInput;
    }

    public boolean isWinningMove() {
        return winningMove;
    }
}
