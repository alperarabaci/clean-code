package pl.refactoring.chain;

import static pl.refactoring.chain.RANKING.STRAIGHT;

public class StraightSpec {
    public StraightSpec() {
    }

    boolean isStraight(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(5)
                && cardSet.isSequential();
    }

    RANKING getStraightRanking() {
        return STRAIGHT;
    }
}