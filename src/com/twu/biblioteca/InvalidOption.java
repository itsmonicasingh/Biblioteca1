package com.twu.biblioteca;

//InvalidOption shows invalid option
public class InvalidOption implements Operations {

    private View view;

    public InvalidOption(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.show(Messages.invalidOption);
    }
}