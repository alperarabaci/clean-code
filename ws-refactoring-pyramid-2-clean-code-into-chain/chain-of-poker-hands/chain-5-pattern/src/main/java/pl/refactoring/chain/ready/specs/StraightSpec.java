package pl.refactoring.chain.ready.specs;

import pl.refactoring.chain.ready.CardSet;
import pl.refactoring.chain.ready.RANKING;

import static pl.refactoring.chain.ready.RANKING.STRAIGHT;

public class StraightSpec implements PokerHandSpec {
    public StraightSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(5) &&
                cardSet.isSequential();
    }

    public RANKING getRanking() {
        return STRAIGHT;
    }
}