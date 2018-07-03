package com.training;

/**
 * Main class that creates {@code Game} instance, initialises that and
 * runs game process
 *
 * @author Liakhovetslyi Bohdan
 */
public class Main {

    // Entry point of programme
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        game.run();
    }
}
