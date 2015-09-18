package com.twu.biblioteca;

//has user details: name, email, ph.no, lib.no, passwrd
public class User {

    String name;
    String emailAddress;
    String phoneNumber;
    String libraryNo;
    String password;
    private boolean isLibrarian;

    public User(String name, String emailAddress, String phoneNumber, String libraryNo, String password, boolean isLibrarian) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.libraryNo = libraryNo;
        this.password = password;
        this.isLibrarian = isLibrarian;
    }

    @Override
    public String toString() {
        return name + " " + emailAddress + " " + phoneNumber;
    }

    public boolean match(String s, String monica) {
        if (libraryNo.equals(s))
            if (password.equals(monica))
                return true;
        return false;
    }

    public String getName() {
        return name;
    }

    public boolean isLibrarian() {
        return isLibrarian;
    }
}