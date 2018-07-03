package com.training.model;

/**
 * The {@code Model} class represents the component
 * of MVC design pattern.
 * It perform function of storing data, state of game
 * and generating statistics.
 *
 * @author Liakhovetskyi Bohdan
 */
public class Model {

    /* State of the game variables */
    private int numberToSolve;
    private int currentMinNumber = 0;
    private int currentMaxNumber = RandomNumberGenerator.RAND_MAX;
    private boolean guessed = false;

    /* Generator of random numbers */
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    /* User statistic */
    Statistic statistic = new Statistic();

    /* Constructor */
    public Model() {
        numberToSolve = randomNumberGenerator.rand();
    }

    /**
     * Function changes state of model, and adds information
     * to statistic in defined format
     *
     * @param value value that have to be processed
     */
    public void processInput(int value) {

        checkForWin(value);

        statistic.addInfo(currentMinNumber, currentMaxNumber, value, guessed);

        refreshModelData(value);
    }

    /**
     * Changing local parameters
     *
     * @param value value according to which the data have to be changed
     */
    private void refreshModelData(int value) {

        // Changing current min number and current max number
        if (value < numberToSolve) {
            setCurrentMinNumber(value + 1);
        } else if (value > numberToSolve) {
            setCurrentMaxNumber(value - 1);
        }

        // Changing random number that user have to guess
        if (!isGuessed()) {
            this.numberToSolve = randomNumberGenerator.rand(getCurrentMinNumber(), getCurrentMaxNumber());
        }
    }

    /**
     * Change state of model if user guessed the number
     *
     * @param value input value
     */
    private void checkForWin(int value) {
        if (value == numberToSolve) {
            setGuessed(true);
        }
    }

    /**
     * Return statistics of game in current turn
     *
     * @return string of statistics
     */
    public String getStatistic() {
        return statistic.formStatistic();
    }

    /* Getters and setters */

    public boolean isGuessed() {
        return guessed;
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

    public int getNumberToSolve() {
        return numberToSolve;
    }

    public void setNumberToSolve(int numberToSolve) {
        this.numberToSolve = numberToSolve;
    }

    public int getCurrentMinNumber() {
        return currentMinNumber;
    }

    public void setCurrentMinNumber(int currentMinNumber) {
        this.currentMinNumber = currentMinNumber;
    }

    public int getCurrentMaxNumber() {
        return currentMaxNumber;
    }

    public void setCurrentMaxNumber(int currentMaxNumber) {
        this.currentMaxNumber = currentMaxNumber;
    }
}
