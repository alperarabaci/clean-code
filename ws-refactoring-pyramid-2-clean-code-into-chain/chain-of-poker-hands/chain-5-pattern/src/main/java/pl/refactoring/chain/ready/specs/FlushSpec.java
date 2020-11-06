package pl.refactoring.chain.ready.specs;

import pl.refactoring.chain.ready.CardSet;
import pl.refactoring.chain.ready.RANKING;

import static pl.refactoring.chain.ready.RANKING.FLUSH;

public class FlushSpec implements PokerHandSpec {
    public FlushSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return cardSet.isAllSameSuit() && !cardSet.isSequential();
    }

    public RANKING getRanking() {
        return FLUSH;
    }
}