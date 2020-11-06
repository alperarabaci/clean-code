package pl.refactoring.chain.ready.specs;

import pl.refactoring.chain.ready.CardSet;
import pl.refactoring.chain.ready.RANKING;

import static pl.refactoring.chain.ready.RANKING.STRAIGHT_FLUSH;

public class StraightFlushSpec implements PokerHandSpec {
    public StraightFlushSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return cardSet.isAllSameSuit() && cardSet.isSequential();
    }

    public RANKING getRanking() {
        return STRAIGHT_FLUSH;
    }
}