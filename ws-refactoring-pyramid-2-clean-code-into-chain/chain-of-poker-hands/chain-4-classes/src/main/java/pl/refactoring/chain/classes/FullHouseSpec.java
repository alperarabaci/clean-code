package pl.refactoring.chain.classes;

import static pl.refactoring.chain.classes.RANKING.FULL_HOUSE;

public class FullHouseSpec {
    public FullHouseSpec() {
    }

    boolean isFullHouse(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(3);
    }

    RANKING getFullHouseRanking() {
        return FULL_HOUSE;
    }
}