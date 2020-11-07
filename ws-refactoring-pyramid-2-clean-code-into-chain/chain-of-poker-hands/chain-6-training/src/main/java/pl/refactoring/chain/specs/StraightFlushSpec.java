package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

import static pl.refactoring.chain.RANKING.STRAIGHT_FLUSH;

public class StraightFlushSpec {
    public StraightFlushSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return cardSet.isAllSameSuit() && cardSet.isSequential();
    }

    public RANKING getStraightRanking() {
        return STRAIGHT_FLUSH;
    }
}