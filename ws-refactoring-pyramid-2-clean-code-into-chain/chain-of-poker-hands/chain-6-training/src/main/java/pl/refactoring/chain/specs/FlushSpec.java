package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

import static pl.refactoring.chain.RANKING.FLUSH;

public class FlushSpec {
    public FlushSpec() {
    }

    boolean isFlush(CardSet cardSet) {
        return cardSet.isAllSameSuit() && !cardSet.isSequential();
    }

    RANKING getFlushRanking() {
        return FLUSH;
    }
}