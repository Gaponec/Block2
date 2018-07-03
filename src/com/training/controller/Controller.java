package com.training.controller;

import com.training.model.Model;
import com.training.view.View;

/**
 * The {@code Controller} class represents the component
 * of MVC design pattern.
 * It perform function of receiving Strings from {@code View} class,
 * validating strings and checking its for completeness to form response
 * for {@code Model} class, that waiting for it from {@code Controller}
 *
 * @author Liakhovetskyi Bohdan
 */
public class Controller {

    /* Local variables, of another MVC components */
    private Model model;
    private View view;

    /* Constructor */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /* Start instance of game */
    public void processUser() {
        // Run cycle of game
        performGameProcessCycle();

        // End of the game and output result
        view.printMessage(View.CONGRATULATION);
        view.printMessage(View.STATISTIC);
        view.printMessage(model.getStatistic());
    }

    /**
     * Try to parse user input as int value
     *
     * @return user input as integer value
     * @throws NumberFormatException generates if user input isn't integer value
     */
    private int parseUserInputAsInt() throws NumberFormatException {
        return Integer.valueOf(view.readUserInput());
    }

    /**
     * Verification input value on right range
     *
     * @param value value that have to be verified
     * @throws NumberRangeException generates if value not included in the range
     */
    public void verifyOnRange(int value) throws NumberRangeException {
        if (value < model.getCurrentMinNumber() || value > model.getCurrentMaxNumber()) {
            throw new NumberRangeException();
        }
    }

    /**
     * Performs function of processing user inputs,
     * changing state of model and updating view
     */
    private void performGameProcessCycle() {

        int currentInput = 0;

        do {

            // Output request for user
            view.printMessage(String.format(View.INPUT_REQUEST_FORMAT, model.getCurrentMinNumber(), model.getCurrentMaxNumber()));

            // Verification of user input
            try {
                currentInput = parseUserInputAsInt();
                verifyOnRange(currentInput);
            } catch (NumberFormatException e) {
                view.printMessage(View.INPUT_FORMAT_ERROR);
                continue;
            } catch (NumberRangeException e) {
                view.printMessage(View.INPUT_INTERVAL_ERROR);
                continue;
            }

            // Changing state of model and updating view
            model.processInput(currentInput);
            view.printMessage(model.getStatistic());

        } while (!model.isGuessed());
    }
}
