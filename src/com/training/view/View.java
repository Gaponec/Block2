package com.training.view;

import java.util.Scanner;

/**
 * The {@code View} class represents the component
 * of MVC design pattern.
 * It perform functions of output information and
 * input information using {@code Scanner} class from
 * command line
 *
 * @author Liakhovetskyi Bohdan
 */
public class View {
    /* Constants */
    public static final String INPUT_REQUEST_FORMAT = "Input number from following range [%d, %d]";
    public static final String INPUT_FORMAT_ERROR = "Error. Input please integer value";
    public static final String INPUT_INTERVAL_ERROR = "Error. Input please number from required range";
    public static final String INPUT_SUCCESS = "Right";
    public static final String CONGRATULATION = "Congratulation! You successfully guessed the number";
    public static final String STATISTIC = "Your statistic:";

    /* Input stream Reader for view */
    private final Scanner scanner = new Scanner(System.in);

    /* Constructor */
    public View() {
    }

    /**
     * Returns result of user's input
     *
     * @return text of user's input
     */
    public String readUserInput() {
        return scanner.next();
    }

    /**
     * Prints message in string format
     *
     * @param message message that have to be printed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}
