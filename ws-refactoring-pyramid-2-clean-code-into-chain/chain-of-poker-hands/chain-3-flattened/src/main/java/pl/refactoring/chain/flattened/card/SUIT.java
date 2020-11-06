package pl.refactoring.chain.flattened.card;

/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * <p>
 * This code is exclusive property of Wlodek Krakowski
 * for usage of attendees of trainings that are conducted by Wlodek Krakowski.
 * <p>
 * This code may not be copied or used without
 * written consent of IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * <p>
 * If willing to do so, please contact the author.
 */
public enum SUIT {
    HEART('\u2764'),
    DIAMOND('\u2666'),
    CLUB('\u2663'),
    SPADE('\u2660');

    private char symbol;

    SUIT(char symbol) {
        this.symbol = symbol;
    }

    public char getChar() {
        return symbol;
    }
}
