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

        if (cardSet.isAllSameSuit()) {
            // Check for straight flush
            if (cardSet.isSequential())
                return new Hand(STRAIGHT_FLUSH, handCards(cardSet));
        }

        if (cardSet.isAllSameSuit()) {
            // Check for straight flush
            if (!cardSet.isSequential())
                return new Hand(FLUSH, handCards(cardSet));
        }
        // else
        // TODO Below logic assumed that cards belong to different suites
        {
            // Check for possible x of a kind
            Map<RANK, List<Card>> cardsByRank = handCards(cardSet).stream().collect(groupingBy(Card::getRank));

            List<RANK> ranks = cardsByRank.keySet()
                    .stream()
                    .collect(Collectors.toList());
            if (ranks.size() == 5) {
                boolean isSequential = cardSet.isSequential();
                if (isSequential)
                    return new Hand(STRAIGHT, handCards(cardSet));
            }
            if (ranks.size() == 2) {
                // Look for four of a kind
                if (cardsByRank.get(ranks.get(0)).size() == 4 ||
                        cardsByRank.get(ranks.get(1)).size() == 4)
                    return new Hand(FOUR_OF_A_KIND, handCards(cardSet));
                    // Look for full house
                else {
                    return new Hand(FULL_HOUSE, handCards(cardSet));
                }
            } else if (ranks.size() == 3) {
                // Look for 3 of a kind
                if (cardsByRank.get(ranks.get(0)).size() == 3 ||
                        cardsByRank.get(ranks.get(1)).size() == 3 ||
                        cardsByRank.get(ranks.get(2)).size() == 3)
                    return new Hand(THREE_OF_A_KIND, handCards(cardSet));

                // Look for 2 pairs
                if (cardsByRank.get(ranks.get(0)).size() == 1 ||
                        cardsByRank.get(ranks.get(1)).size() == 1 ||
                        cardsByRank.get(ranks.get(2)).size() == 1)
                    return new Hand(TWO_PAIRS, handCards(cardSet));
            } else if (ranks.size() == 4) {
                return new Hand(ONE_PAIR, handCards(cardSet));
            }
        }

        return new Hand(HIGH_CARD, handCards(cardSet));
    }

    private List<Card> handCards(CardSet cardSet) {
        return cardSet.getSortedCards();
    }

}
