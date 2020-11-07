package pl.refactoring.chain;

import pl.refactoring.chain.card.Card;
import pl.refactoring.chain.specs.*;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

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
    private final PokerHandSpec straightFlushSpec = new StraightFlushSpec();
    private final PokerHandSpec fourOfAKindSpec = new FourOfAKindSpec();
    private final PokerHandSpec fullHouseSpec = new FullHouseSpec();
    private final PokerHandSpec flushSpec = new FlushSpec();
    private final PokerHandSpec straightSpec = new StraightSpec();
    private final PokerHandSpec threeOfAKindSpec = new ThreeOfAKindSpec();
    private final PokerHandSpec twoPairsSpec = new TwoPairsSpec();
    private final PokerHandSpec onePairSpec = new OnePairSpec();
    private final PokerHandSpec highCardSpec = new HighCardSpec();

    public Hand hand(CardSet cardSet) {
        return Stream.of(straightFlushSpec,
                fourOfAKindSpec,
                fullHouseSpec,
                flushSpec,
                straightSpec,
                threeOfAKindSpec,
                threeOfAKindSpec,
                twoPairsSpec,
                onePairSpec,
                highCardSpec)
        .filter(pokerHandSpec -> pokerHandSpec.isSatisfiedBy(cardSet))
        .findFirst()
        .map(pokerHandSpec -> new Hand(pokerHandSpec.getRanking(), cardSet.getSortedCards()))
        .orElseThrow(() -> new IllegalStateException("Poker Hand not recognized."));
    }

    private List<Card> handCards(CardSet cardSet) {
        return cardSet.getSortedCards();
    }

}
