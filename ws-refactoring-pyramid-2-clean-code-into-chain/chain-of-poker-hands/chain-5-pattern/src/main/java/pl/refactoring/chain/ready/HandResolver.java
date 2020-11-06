package pl.refactoring.chain.ready;


import pl.refactoring.chain.ready.card.Card;
import pl.refactoring.chain.ready.specs.*;

import java.util.List;
import java.util.stream.Stream;

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
public class HandResolver {
    private static final PokerHandSpec STRAIGHT_FLUSH_SPEC = new StraightFlushSpec();
    private static final PokerHandSpec FOUR_OF_A_KIND_SPEC = new FourOfAKindSpec();
    private static final PokerHandSpec FULL_HOUSE_SPEC = new FullHouseSpec();
    private static final PokerHandSpec FLUSH_SPEC = new FlushSpec();
    private static final PokerHandSpec STRAIGHT_SPEC = new StraightSpec();
    private static final PokerHandSpec THREE_OF_A_KIND_SPEC = new ThreeOfAKindSpec();
    private static final PokerHandSpec TWO_PAIRS_SPEC = new TwoPairsSpec();
    private static final PokerHandSpec ONE_PAIR_SPEC = new OnePairSpec();
    private static final PokerHandSpec HIGH_CARD_SPEC = new HighCardSpec();

    public Hand hand(CardSet cardSet) {
        return Stream.of(STRAIGHT_FLUSH_SPEC,
                FOUR_OF_A_KIND_SPEC,
                FULL_HOUSE_SPEC,
                FLUSH_SPEC,
                STRAIGHT_SPEC,
                THREE_OF_A_KIND_SPEC,
                TWO_PAIRS_SPEC,
                ONE_PAIR_SPEC,
                HIGH_CARD_SPEC)
        .filter(pokerHandSpec -> pokerHandSpec.isSatisfiedBy(cardSet))
        .findFirst()
        .map(pokerHandSpec -> new Hand(pokerHandSpec.getRanking(), cardSet.getSortedCards()))
        .orElseThrow(() -> new IllegalStateException("Poker Hand not recognized"));
    }

    private List<Card> handCards(CardSet cardSet) {
        return cardSet.getSortedCards();
    }

}
