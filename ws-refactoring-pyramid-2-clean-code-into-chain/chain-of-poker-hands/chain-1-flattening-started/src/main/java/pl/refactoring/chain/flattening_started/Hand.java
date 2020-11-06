package pl.refactoring.chain.flattening_started;

import pl.refactoring.chain.flattening_started.card.Card;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

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
public class Hand {
    private final RANKING ranking;
    private final SortedSet<Card> cardList;

    public Hand(RANKING ranking, List<Card> cardList) {
        this.ranking = ranking;
        this.cardList = new TreeSet<>(cardList);
    }

    public RANKING getRanking() {
        return ranking;
    }

    public SortedSet<Card> getSortedCards() {
        return cardList;
    }
}
