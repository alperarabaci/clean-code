package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

import static pl.refactoring.chain.RANKING.STRAIGHT;

public class StraightSpec {
    public StraightSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(5)
                && cardSet.isSequential();
    }

    public RANKING getStraightRanking() {
        return STRAIGHT;
    }
}