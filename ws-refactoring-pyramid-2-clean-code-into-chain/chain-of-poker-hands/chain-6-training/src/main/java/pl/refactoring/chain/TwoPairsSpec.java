package pl.refactoring.chain;

import static pl.refactoring.chain.RANKING.TWO_PAIRS;

public class TwoPairsSpec {
    public TwoPairsSpec() {
    }

    boolean isTwoPairs(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(3)
                && cardSet.containsRankWithMultiplicity(1);
    }

    RANKING getTwoPairsRanking() {
        return TWO_PAIRS;
    }
}