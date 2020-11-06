package pl.refactoring.chain.ready.specs;

import pl.refactoring.chain.ready.CardSet;
import pl.refactoring.chain.ready.RANKING;

import static pl.refactoring.chain.ready.RANKING.FULL_HOUSE;

public class FullHouseSpec implements PokerHandSpec {
    public FullHouseSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(3);
    }

    public RANKING getRanking() {
        return FULL_HOUSE;
    }
}