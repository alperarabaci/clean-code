package pl.refactoring.chain;

import pl.refactoring.chain.card.Card;
import pl.refactoring.chain.card.RANK;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        if (cardSet.isAllSameSuit() && cardSet.isSequential()) {
            return new Hand(STRAIGHT_FLUSH, handCards(cardSet));
        }

        if (cardSet.isAllSameSuit() && !cardSet.isSequential()) {
            return new Hand(FLUSH, handCards(cardSet));
        }

        if (!cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(5)
                && cardSet.isSequential()) {
            return new Hand(STRAIGHT, handCards(cardSet));
        }


        if (!cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(4)) {
            return new Hand(FOUR_OF_A_KIND, handCards(cardSet));
        }

        if (!cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(3)) {
            return new Hand(FULL_HOUSE, handCards(cardSet));
        }

        if (!cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(3)
                && cardSet.containsRankWithMultiplicity(3)) {
            return new Hand(THREE_OF_A_KIND, handCards(cardSet));
        }

        if (!cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(3)
                && cardSet.containsRankWithMultiplicity(1)) {
            return new Hand(TWO_PAIRS, handCards(cardSet));
        }

        if (!cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(4)) {
            return new Hand(ONE_PAIR, handCards(cardSet));
        }
        if (!cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(5)) {
            return new Hand(HIGH_CARD, handCards(cardSet));
        }

        throw new IllegalStateException("Poker Hand not recognized.");
    }

    private Map<RANK, List<Card>> cardsByRank(CardSet cardSet) {
        return handCards(cardSet).stream()
                .collect(groupingBy(Card::getRank));
    }

    private List<Card> handCards(CardSet cardSet) {
        return cardSet.getSortedCards();
    }

}
