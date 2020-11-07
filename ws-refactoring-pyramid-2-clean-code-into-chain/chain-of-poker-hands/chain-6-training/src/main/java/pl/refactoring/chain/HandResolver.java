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
    public Hand hand(CardSet cardSet) {

        if (cardSet.isStraightFlush()) {
            return new Hand(STRAIGHT_FLUSH, cardSet.handCards());
        }

        if (cardSet.isFlush()) {
            return new Hand(FLUSH, cardSet.handCards());
        }

        if (cardSet.isStraight()) {
            return new Hand(STRAIGHT, cardSet.handCards());
        }

        if (cardSet.isFourOfAKind()) {
            return new Hand(FOUR_OF_A_KIND, cardSet.handCards());
        }

        if (cardSet.isFullHouse()) {
            return new Hand(FULL_HOUSE, cardSet.handCards());
        }

        if (cardSet.isThreeOfAKind()) {
            return new Hand(THREE_OF_A_KIND, cardSet.handCards());
        }

        if (cardSet.isTwoPairs()) {
            return new Hand(TWO_PAIRS, cardSet.handCards());
        }

        if (cardSet.isOnePair()) {
            return new Hand(ONE_PAIR, cardSet.handCards());
        }

        if (cardSet.isHighCard()) {
            return new Hand(HIGH_CARD, cardSet.handCards());
        }

        throw new IllegalStateException("Poker Hand not recognized.");
    }

    private Map<RANK, List<Card>> cardsByRank(CardSet cardSet) {
        return cardSet.handCards().stream()
                .collect(groupingBy(Card::getRank));
    }

}
