package pl.refactoring.chain.flattening_continued;

import pl.refactoring.chain.flattening_continued.card.Card;
import pl.refactoring.chain.flattening_continued.card.RANK;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static pl.refactoring.chain.flattening_continued.RANKING.*;

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

        if (!cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(5) &&
                cardSet.isSequential()) {
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

        // else removed
        // TODO Below logic assumes that cards belong to different suites
        // Check for possible x of a kind

        List<RANK> ranks = cardsByRank(cardSet).keySet()
                .stream()
                .collect(Collectors.toList());



        if (cardSet.hasRankDiversity(3)) {
            // Look for 3 of a kind
            if (cardsByRank(cardSet).get(ranks.get(0)).size() == 3 ||
                    cardsByRank(cardSet).get(ranks.get(1)).size() == 3 ||
                    cardsByRank(cardSet).get(ranks.get(2)).size() == 3)
                return new Hand(THREE_OF_A_KIND, handCards(cardSet));

            // Look for 2 pairs
            if (cardsByRank(cardSet).get(ranks.get(0)).size() == 1 ||
                    cardsByRank(cardSet).get(ranks.get(1)).size() == 1 ||
                    cardsByRank(cardSet).get(ranks.get(2)).size() == 1)
                return new Hand(TWO_PAIRS, handCards(cardSet));
        }

        if (cardSet.hasRankDiversity(4)) {
            return new Hand(ONE_PAIR, handCards(cardSet));
        }

        return new Hand(HIGH_CARD, handCards(cardSet));
    }

    private Map<RANK, List<Card>> cardsByRank(CardSet cardSet) {
        return handCards(cardSet).stream()
                .collect(groupingBy(Card::getRank));
    }

    private List<Card> handCards(CardSet cardSet) {
        return cardSet.getSortedCards();
    }

}
