package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

import static pl.refactoring.chain.RANKING.FULL_HOUSE;

public class FullHouseSpec {
    public FullHouseSpec() {
    }

    public boolean isFullHouse(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(3);
    }

    public RANKING getFullHouseRanking() {
        return FULL_HOUSE;
    }
}