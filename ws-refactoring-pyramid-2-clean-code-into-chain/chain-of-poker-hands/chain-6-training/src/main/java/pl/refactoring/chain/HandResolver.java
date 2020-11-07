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

    public Hand hand(CardSet cardSet) {

        if (isStraightFlush(cardSet)) {
            return new Hand(STRAIGHT_FLUSH, handCards(cardSet));
        }

        if (isFlush(cardSet)) {
            return new Hand(FLUSH, handCards(cardSet));
        }

        if (isStraight(cardSet)) {
            return new Hand(STRAIGHT, handCards(cardSet));
        }


        if (IsFourOfAKind(cardSet)) {
            return new Hand(FOUR_OF_A_KIND, handCards(cardSet));
        }

        if (isFullHouse(cardSet)) {
            return new Hand(FULL_HOUSE, handCards(cardSet));
        }

        if (isThreeOfAKind(cardSet)) {
            return new Hand(THREE_OF_A_KIND, handCards(cardSet));
        }

        if (isTwoPairs(cardSet)) {
            return new Hand(TWO_PAIRS, handCards(cardSet));
        }

        if (isOnePair(cardSet)) {
            return new Hand(ONE_PAIR, handCards(cardSet));
        }
        if (highCardSpec.isHighCard(cardSet)) {
            return new Hand(HIGH_CARD, handCards(cardSet));
        }

        throw new IllegalStateException("Poker Hand not recognized.");
    }

    private boolean isHighCard(CardSet cardSet) {
        return highCardSpec.isHighCard(cardSet);
    }

    private boolean isOnePair(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(4);
    }

    private boolean isTwoPairs(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(3)
                && cardSet.containsRankWithMultiplicity(1);
    }

    private boolean isThreeOfAKind(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(3)
                && cardSet.containsRankWithMultiplicity(3);
    }

    private boolean isFullHouse(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(3);
    }

    private boolean IsFourOfAKind(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(4);
    }

    private boolean isStraight(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(5)
                && cardSet.isSequential();
    }

    private boolean isFlush(CardSet cardSet) {
        return cardSet.isAllSameSuit() && !cardSet.isSequential();
    }

    private boolean isStraightFlush(CardSet cardSet) {
        return cardSet.isAllSameSuit() && cardSet.isSequential();
    }

    private Map<RANK, List<Card>> cardsByRank(CardSet cardSet) {
        return handCards(cardSet).stream()
                .collect(groupingBy(Card::getRank));
    }

    private List<Card> handCards(CardSet cardSet) {
        return cardSet.getSortedCards();
    }

}
