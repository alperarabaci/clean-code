package pl.refactoring.chain;

import pl.refactoring.chain.card.Card;
import pl.refactoring.chain.specs.*;

import java.util.List;

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
            return new Hand(straightFlushSpec.getStraightRanking(), handCards(cardSet));
        }

        if (flushSpec.isFlush(cardSet)) {
            return new Hand(flushSpec.getFlushRanking(), handCards(cardSet));
        }

        if (straightSpec.isStraight(cardSet)) {
            return new Hand(straightSpec.getStraightRanking(), handCards(cardSet));
        }

        if (fourOfAKindSpec.IsFourOfAKind(cardSet)) {
            return new Hand(fourOfAKindSpec.getFourOfAKindRanking(), handCards(cardSet));
        }

        if (fullHouseSpec.isFullHouse(cardSet)) {
            return new Hand(fullHouseSpec.getFullHouseRanking(), handCards(cardSet));
        }

        if (threeOfAKindSpec.isThreeOfAKind(cardSet)) {
            return new Hand(threeOfAKindSpec.getThreeOfAKindRanking(), handCards(cardSet));
        }

        if (twoPairsSpec.isTwoPairs(cardSet)) {
            return new Hand(twoPairsSpec.getTwoPairsRanking(), handCards(cardSet));
        }

        if (onePairSpec.isOnePair(cardSet)) {
            return new Hand(onePairSpec.getOnePairRanking(), handCards(cardSet));
        }
        if (highCardSpec.isHighCard(cardSet)) {
            return new Hand(highCardSpec.getHighCardRanking(), handCards(cardSet));
        }

        throw new IllegalStateException("Poker Hand not recognized.");
    }

    private List<Card> handCards(CardSet cardSet) {
        return cardSet.getSortedCards();
    }

}
