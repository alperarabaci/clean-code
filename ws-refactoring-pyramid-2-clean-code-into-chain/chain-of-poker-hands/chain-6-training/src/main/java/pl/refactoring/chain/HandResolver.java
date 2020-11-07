package pl.refactoring.chain;

import pl.refactoring.chain.card.Card;
import pl.refactoring.chain.card.RANK;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static pl.refactoring.chain.RANKING.*;

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
    private final HighCardSpec highCardSpec = new HighCardSpec();
    private final StraightFlushSpec straightFlushSpec = new StraightFlushSpec();
    private final FlushSpec flushSpec = new FlushSpec();
    private final OnePairSpec onePairSpec = new OnePairSpec();
    private final TwoPairsSpec twoPairsSpec = new TwoPairsSpec();
    private final ThreeOfAKindSpec threeOfAKindSpec = new ThreeOfAKindSpec();
    private final FullHouseSpec fullHouseSpec = new FullHouseSpec();
    private final FourOfAKindSpec fourOfAKindSpec = new FourOfAKindSpec();
    private final StraightSpec straightSpec = new StraightSpec();

    public Hand hand(CardSet cardSet) {

        if (straightFlushSpec.isStraightFlush(cardSet)) {
            return new Hand(STRAIGHT_FLUSH, handCards(cardSet));
        }

        if (flushSpec.isFlush(cardSet)) {
            return new Hand(FLUSH, handCards(cardSet));
        }

        if (straightSpec.isStraight(cardSet)) {
            return new Hand(STRAIGHT, handCards(cardSet));
        }


        if (fourOfAKindSpec.IsFourOfAKind(cardSet)) {
            return new Hand(FOUR_OF_A_KIND, handCards(cardSet));
        }

        if (fullHouseSpec.isFullHouse(cardSet)) {
            return new Hand(FULL_HOUSE, handCards(cardSet));
        }

        if (threeOfAKindSpec.isThreeOfAKind(cardSet)) {
            return new Hand(THREE_OF_A_KIND, handCards(cardSet));
        }

        if (twoPairsSpec.isTwoPairs(cardSet)) {
            return new Hand(TWO_PAIRS, handCards(cardSet));
        }

        if (onePairSpec.isOnePair(cardSet)) {
            return new Hand(ONE_PAIR, handCards(cardSet));
        }
        if (highCardSpec.isHighCard(cardSet)) {
            return new Hand(HIGH_CARD, handCards(cardSet));
        }

        throw new IllegalStateException("Poker Hand not recognized.");
    }

    private List<Card> handCards(CardSet cardSet) {
        return cardSet.getSortedCards();
    }

}
