package com.twu.biblioteca;

//Quit quits the application
public class Quit implements Operations {

    public Quit() {
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}