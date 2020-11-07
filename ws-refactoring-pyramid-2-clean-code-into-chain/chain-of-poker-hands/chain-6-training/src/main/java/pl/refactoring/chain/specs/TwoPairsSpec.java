package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

import static pl.refactoring.chain.RANKING.TWO_PAIRS;

public class TwoPairsSpec {
    public TwoPairsSpec() {
    }

    public boolean isTwoPairs(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(3)
                && cardSet.containsRankWithMultiplicity(1);
    }

    public RANKING getTwoPairsRanking() {
        return TWO_PAIRS;
    }
}