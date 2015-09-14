package com.twu.biblioteca;

import java.util.Scanner;

//Input reads input from the user
public class UserInput {

    private Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read() {
        String input;
        input = scanner.nextLine();
        return input;
    }
}

