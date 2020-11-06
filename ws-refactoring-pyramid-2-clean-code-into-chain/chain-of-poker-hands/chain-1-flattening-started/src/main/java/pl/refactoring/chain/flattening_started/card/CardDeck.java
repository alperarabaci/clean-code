package pl.refactoring.chain.flattening_started.card;

import java.util.*;

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
public class CardDeck {
    private final List<Card> cards;

    public CardDeck(Set<Card> cards) {
        this.cards = new ArrayList<>(cards);
        Collections.shuffle(this.cards);
    }

    // Immutable
    public SortedSet<Card> getRemainingCards() {
        return new TreeSet<>(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }
}
