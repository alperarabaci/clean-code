package pl.refactoring.chain.ready.specs;

import pl.refactoring.chain.ready.CardSet;
import pl.refactoring.chain.ready.RANKING;

import static pl.refactoring.chain.ready.RANKING.FOUR_OF_A_KIND;

public class FourOfAKindSpec implements PokerHandSpec {
    public FourOfAKindSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(4);
    }

    public RANKING getRanking() {
        return FOUR_OF_A_KIND;
    }
}