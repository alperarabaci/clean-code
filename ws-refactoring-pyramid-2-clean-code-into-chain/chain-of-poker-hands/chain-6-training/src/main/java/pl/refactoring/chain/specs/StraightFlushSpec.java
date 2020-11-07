package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

import static pl.refactoring.chain.RANKING.STRAIGHT_FLUSH;

public class StraightFlushSpec implements PokerHandSpec {
    public StraightFlushSpec() {
    }

    @Override
    public boolean isSatisfiedBy(CardSet cardSet) {
        return cardSet.isAllSameSuit() && cardSet.isSequential();
    }

    @Override
    public RANKING getRanking() {
        return STRAIGHT_FLUSH;
    }
}