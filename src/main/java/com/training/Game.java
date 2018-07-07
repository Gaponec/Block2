package com.training;

import com.training.controller.Controller;
import com.training.model.Model;
import com.training.view.View;

/**
 * Class {@code Game} represents entity of Game
 * that contain MVC design pattern's components
 *
 * @author Liakhovetslyi Bohdan
 */
public class Game {

    /* Components of MVC design pattern */
    private Model model;
    private View view;
    private Controller controller;

    /* Constructor */
    public Game() {

    }

    /**
     * Function that initializes all components
     */
    public void init() {
        this.model = new Model();
        this.view = new View();
        this.controller = new Controller(this.model, this.view);
    }

    /**
     * Function that run the game if all components were initialized
     */
    public void run() {
        try {
            controller.processUser();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
