package pl.refactoring.chain.classes;

import static pl.refactoring.chain.classes.RANKING.TWO_PAIRS;

public class TwoPairsSpec {
    public TwoPairsSpec() {
    }

    boolean isTwoPairs(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(3) &&
                cardSet.containsRankWithMultiplicity(2);
    }

    RANKING getTwoPairsRanking() {
        return TWO_PAIRS;
    }
}