package pl.refactoring.chain;

import static pl.refactoring.chain.RANKING.STRAIGHT_FLUSH;

public class StraightFlushSpec {
    public StraightFlushSpec() {
    }

    boolean isStraightFlush(CardSet cardSet) {
        return cardSet.isAllSameSuit() && cardSet.isSequential();
    }

    RANKING getStraightRanking() {
        return STRAIGHT_FLUSH;
    }
}