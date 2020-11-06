package pl.refactoring.chain.flattening_continued;

import pl.refactoring.chain.flattening_continued.card.Card;
import pl.refactoring.chain.flattening_continued.card.CardDeck;
import pl.refactoring.chain.flattening_continued.card.CardDeckFactory;

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
public class PokerHandResolverMain {
    public static void main(String[] args) {
        CardDeckFactory factory = new CardDeckFactory();
        CardDeck deck = factory.createDeck(52);

        Card card1 = deck.draw();
        Card card2 = deck.draw();
        Card card3 = deck.draw();
        Card card4 = deck.draw();
        Card card5 = deck.draw();

        HandResolver handResolver = new HandResolver();
        Hand hand = handResolver.hand(new CardSet(card1, card2, card3, card4, card5));

        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
        System.out.println(card4);
        System.out.println(card5);

        System.out.println(hand.getRanking());
    }
}
