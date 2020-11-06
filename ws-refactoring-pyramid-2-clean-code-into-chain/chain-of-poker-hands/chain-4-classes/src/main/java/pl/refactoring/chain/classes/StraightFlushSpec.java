package pl.refactoring.chain.classes;

import static pl.refactoring.chain.classes.RANKING.STRAIGHT_FLUSH;

public class StraightFlushSpec {
    public StraightFlushSpec() {
    }

    boolean isStraightFlush(CardSet cardSet) {
        return cardSet.isAllSameSuit() && cardSet.isSequential();
    }

    RANKING getStraightFlushRanking() {
        return STRAIGHT_FLUSH;
    }
}